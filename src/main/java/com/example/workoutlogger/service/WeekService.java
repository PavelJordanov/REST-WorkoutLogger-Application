package com.example.workoutlogger.service;

import java.util.List;

import com.example.workoutlogger.model.Week;

public interface WeekService {
    public List<Week> findAll();
    public Week findById(String id);
    public void deleteById(String id);
    public int insert(Week week);
    public int update(Week week);
    void markWeekAsDone(String id);
}