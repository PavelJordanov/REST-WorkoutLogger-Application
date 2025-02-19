package com.example.workoutlogger.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.workoutlogger.model.Program;

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

    public List<Program> findall() {
        System.out.println("Here3!!!");
        return jdbcTemplate.query("select * from programs", new ProgramRowMapper());
    }

    public Program findById(String id) {
        return jdbcTemplate.queryForObject("select * from programs where id=?", new ProgramRowMapper(), id);
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