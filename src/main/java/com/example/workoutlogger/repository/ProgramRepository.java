package com.example.workoutlogger.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.workoutlogger.model.Program;
import com.example.workoutlogger.model.Week;
import com.example.workoutlogger.model.Workout;
import com.example.workoutlogger.model.Exercise;

@Repository
public class ProgramRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static class ProgramRowMapper implements RowMapper<Program> {
        @Override
        public Program mapRow(ResultSet rs, int rowNum) throws SQLException {
            Program program = new Program();
            program.setId(rs.getString("id"));
            program.setName(rs.getString("name"));
            program.setDone(rs.getBoolean("done"));
            return program;
        }
    }

    public class ProgramExtractor implements ResultSetExtractor<Program> {
        @Override
        public Program extractData(ResultSet rs) throws SQLException {
            Program program = null;
            // Maps to track which Week, Workout we’ve already created
            Map<String, Week> weekMap = new HashMap<>();
            Map<String, Workout> workoutMap = new HashMap<>();

            while (rs.next()) {
                // If it’s the first row, build the Program
                if (program == null) {
                    program = new Program();
                    program.setId(rs.getString("program_id"));
                    program.setName(rs.getString("program_name"));
                    program.setDone(rs.getBoolean("program_done"));
                }

                // For each row, see if there's a Week ID
                String weekId = rs.getString("week_id");
                if (weekId != null) {
                    Week week = weekMap.get(weekId);
                    if (week == null) {
                        week = new Week();
                        week.setId(weekId);
                        week.setDone(rs.getBoolean("week_done"));
                        // add it to Program
                        program.getWeeks().add(week);
                        weekMap.put(weekId, week);
                    }

                    // For each row, see if there's a Workout ID
                    String workoutId = rs.getString("workout_id");
                    if (workoutId != null) {
                        Workout workout = workoutMap.get(workoutId);
                        if (workout == null) {
                            workout = new Workout();
                            workout.setId(workoutId);
                            workout.setName(rs.getString("workout_name"));
                            workout.setDone(rs.getBoolean("workout_done"));
                            // add it to the correct Week
                            week.getWorkouts().add(workout);
                            workoutMap.put(workoutId, workout);
                        }

                        // For each row, see if there's an Exercise ID
                        String exerciseId = rs.getString("exercise_id");
                        if (exerciseId != null) {
                            Exercise exercise = new Exercise();
                            exercise.setId(exerciseId);
                            exercise.setName(rs.getString("exercise_name"));
                            exercise.setSets(rs.getInt("sets"));
                            exercise.setReps(rs.getInt("reps"));
                            exercise.setWeight(rs.getFloat("weight"));
                            exercise.setDone(rs.getBoolean("exercise_done"));
                            // add it to the correct Workout
                            workout.getExercises().add(exercise);
                        }
                    }
                }
            }

            return program;
        }
    }

    public List<Program> findall() {
        System.out.println("Here3!!!");
        return jdbcTemplate.query("select * from programs", new ProgramRowMapper());
    }

    public Program findById(String id) {
        return jdbcTemplate.queryForObject("select * from programs where id=?", new ProgramRowMapper(), id);
    }

    public Program findByIdFull(String id) {
        String sql = """
            SELECT
              program.id           AS program_id,
              program.name         AS program_name,
              program.done         AS program_done,
              week.id           AS week_id,
              week.done         AS week_done,
              workout.id          AS workout_id,
              workout.name        AS workout_name,
              workout.done        AS workout_done,
              exercise.id           AS exercise_id,
              exercise.name         AS exercise_name,
              exercise.sets         AS sets,
              exercise.reps         AS reps,
              exercise.weight       AS weight,
              exercise.done         AS exercise_done
            FROM programs program
            LEFT JOIN weeks week ON program.id = week.programId
            LEFT JOIN workouts workout ON week.id = workout.weekId
            LEFT JOIN exercises exercise ON workout.id = exercise.workoutId
            WHERE program.id = ?
        """;
    
        return jdbcTemplate.query(sql, new ProgramExtractor(), id);
    }

    public void deleteById(String id) {
        jdbcTemplate.update("delete from programs where id=?", id);
    }
    
    public int insert(Program program) {
        return jdbcTemplate.update("INSERT INTO programs (id, name, done) VALUES (?, ?, ?)", 
        program.getId(), program.getName(), program.getDone());
    }

    public int update(Program program) {
        return jdbcTemplate.update(
            "UPDATE programs SET name = ?, done = ? WHERE id = ?",
            program.getName(), program.getDone(), program.getId());
    }
}