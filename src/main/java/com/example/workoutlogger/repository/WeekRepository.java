package com.example.workoutlogger.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.workoutlogger.model.Program;
import com.example.workoutlogger.model.Week;

@Repository
public class WeekRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static class WeekRowMapper implements RowMapper<Week> {
        @Override
        public Week mapRow(ResultSet rs, int rowNum) throws SQLException {
            Week week = new Week();
            week.setId(rs.getString("id"));
            week.setProgramId(rs.getString("programId"));
            week.setDone(rs.getBoolean("done"));
            return week;
        }
    }

    public List<Week> findall() {
        System.out.println("Here3!!!");
        return jdbcTemplate.query("select * from weeks", new WeekRowMapper());
    }

    public Week findById(String id) {
        return jdbcTemplate.queryForObject("select * from weeks where id=?", new WeekRowMapper(), id);
    }

    public void deleteById(String id) {
        jdbcTemplate.update("delete from weeks where id=?", id);
    }
    
    public int insert(Week week) {
        return jdbcTemplate.update("INSERT INTO weeks (id, programId, done) VALUES (?, ?, ?)", 
        week.getId(), week.getProgramId(), week.getDone());
    }

    public void batchInsert(List<Week> weeks, String programId) {
        String sql = "INSERT INTO weeks (id, programId, done) VALUES (?, ?, ?)";

        List<Object[]> batchArgs = new ArrayList<>();
        for (Week week : weeks) {
            week.setProgramId(programId);

            batchArgs.add(new Object[] {
                week.getId(),
                week.getProgramId(),
                week.getDone()
            });
        }

        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    public int update(Week week) {
        return jdbcTemplate.update(
            "UPDATE weeks SET programId = ?, done = ? WHERE id = ?",
            week.getProgramId(), week.getDone(), week.getId());
    }
}
