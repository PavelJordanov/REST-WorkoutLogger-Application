package com.example.workoutlogger.service;

import java.util.List;

import com.example.workoutlogger.model.Exercise;;

public interface ExerciseService {
    
    public List<Exercise> findAll();
    public Exercise findById(String id);
    public void deleteById(String id);
    public int insert(Exercise exercise);
    public int update(Exercise exercise);

}