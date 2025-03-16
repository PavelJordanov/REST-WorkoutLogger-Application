package com.example.workoutlogger.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.workoutlogger.model.Exercise;
import com.example.workoutlogger.model.Workout;

@Repository
public class ExerciseRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static class ExerciseRowMapper implements RowMapper<Exercise> {
        @Override
        public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
            Exercise exercise = new Exercise();
            exercise.setId(rs.getString("id"));
            exercise.setWorkoutId(rs.getString("workoutId"));
            exercise.setName(rs.getString("name"));
            exercise.setSets(rs.getInt("sets"));
            exercise.setReps(rs.getInt("reps"));
            exercise.setWeight(rs.getFloat("weight"));
            exercise.setDone(rs.getBoolean("done"));
            return exercise;
        }
    }
    
    public List<Exercise> findall() {
        System.out.println("Here3!!!");
        return jdbcTemplate.query("select * from exercises", new ExerciseRowMapper());
    }

    public Exercise findById(String id) {
        return jdbcTemplate.queryForObject("select * from exercises where id=?", new ExerciseRowMapper(), id);
    }

    public void deleteById(String id) {
        jdbcTemplate.update("delete from exercises where id=?", id);
    }
    
    public int insert(Exercise exercise) {
        return jdbcTemplate.update("INSERT INTO exercises (id, workoutId, name, sets, reps, weight, done) VALUES (?, ?, ?, ?, ?, ?, ?)", 
        exercise.getId(), exercise.getWorkoutId(), exercise.getName(), exercise.getSets(), exercise.getReps(), 
        exercise.getWeight(), exercise.getDone());
    }

    public void batchInsert(List<Workout> workouts) {
        String sql = "INSERT INTO exercises (id, workoutId, name, sets, reps, weight, done) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        List<Object[]> batchArgs = workouts.stream().flatMap(workout ->
            workout.getExercises().stream().map(exercise ->
                new Object[] {
                    exercise.getId(),
                    workout.getId(),
                    exercise.getName(),
                    exercise.getSets(),
                    exercise.getReps(),
                    exercise.getWeight(),
                    exercise.getDone()
                }
            ).toList().stream()
        ).toList();
        jdbcTemplate.batchUpdate(sql, batchArgs);

    }

    public int update(Exercise exercise) {
        return jdbcTemplate.update(
            "UPDATE exercises SET workoutId = ?, name = ?, sets = ?, reps = ?, weight = ?, done = ? WHERE id = ?",
            exercise.getWorkoutId(), exercise.getName(), exercise.getSets(), exercise.getReps(), exercise.getWeight(), 
            exercise.getDone(), exercise.getId());
    }
}
