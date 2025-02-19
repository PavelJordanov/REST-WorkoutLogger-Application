package com.example.workoutlogger.service;

import java.util.List;

import com.example.workoutlogger.model.Program;

public interface ProgramService {
    public List<Program> findAll();
    public Program findById(String id);
    public void deleteById(String id);
    public int insert(Program program);
    public int update(Program program);
    void markProgramAsDone(String id);
}