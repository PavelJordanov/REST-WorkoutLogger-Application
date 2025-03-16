package com.example.workoutlogger.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.workoutlogger.model.Week;
import com.example.workoutlogger.model.Workout;

@Repository
public class WorkoutRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static class WorkoutRowMapper implements RowMapper<Workout> {
        @Override
        public Workout mapRow(ResultSet rs, int rowNum) throws SQLException {
            Workout workout = new Workout();
            workout.setId(rs.getString("id"));
            workout.setWeekId(rs.getString("weekId"));
            workout.setName(rs.getString("name"));
            workout.setDone(rs.getBoolean("done"));
            return workout;
        }
    }
    
    public List<Workout> findall() {
        System.out.println("Here3!!!");
        return jdbcTemplate.query("select * from workouts", new WorkoutRowMapper());
    }

    public Workout findById(String id) {
        return jdbcTemplate.queryForObject("select * from workouts where id=?", new WorkoutRowMapper(), id);
    }

    public void deleteById(String id) {
        jdbcTemplate.update("delete from workouts where id=?", id);
    }
    
    public int insert(Workout workout) {
        return jdbcTemplate.update("INSERT INTO workouts (id, weekId, name, done) VALUES (?, ?, ?, ?)", 
        workout.getId(), workout.getWeekId(), workout.getName(), workout.getDone());
    }

    public void batchInsert(List<Week> weeks) {
        String sql = "INSERT INTO workouts (id, weekId, name, done) VALUES (?, ?, ?, ?)";

        List<Object[]> batchArgs = weeks.stream().flatMap(week -> 
            week.getWorkouts().stream().map(workout ->
                new Object[] {
                    workout.getId(),
                    week.getId(),
                    workout.getName(),
                    workout.getDone()
                }
            ).toList().stream()
        ).toList();
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    public int update(Workout workout) {
        return jdbcTemplate.update(
            "UPDATE workouts SET weekId = ?, name = ?, done = ? WHERE id = ?",
            workout.getWeekId(), workout.getName(), workout.getDone(), workout.getId());
    }
}