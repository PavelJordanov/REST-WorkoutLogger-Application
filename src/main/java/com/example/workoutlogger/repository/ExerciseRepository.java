package com.example.workoutlogger.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.workoutlogger.model.Exercise;

@Repository
public class ExerciseRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static class ExerciseRowMapper implements RowMapper<Exercise> {
        @Override
        public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
            Exercise exercise = new Exercise();
            exercise.setId(rs.getString("id"));
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
        return jdbcTemplate.update("INSERT INTO exercises (id, name, sets, reps, weight, done) VALUES (?, ?, ?, ?, ?, ?)", 
        exercise.getId(), exercise.getName(), exercise.getSets(), exercise.getReps(), 
        exercise.getWeight(), exercise.getDone());
    }

    public int update(Exercise exercise) {
        return jdbcTemplate.update(
            "UPDATE exercises SET name = ?, sets = ?, reps = ?, weight = ?, done = ? WHERE id = ?",
            exercise.getName(), exercise.getSets(), exercise.getReps(), exercise.getWeight(), 
            exercise.getDone(), exercise.getId());
    }
}
