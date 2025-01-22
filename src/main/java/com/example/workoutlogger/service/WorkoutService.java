package com.example.workoutlogger.service;

import java.util.List;

import com.example.workoutlogger.model.Workout;

public interface WorkoutService {
    
    public List<Workout> findAll();
    public Workout findById(String id);
    public void deleteById(String id);
    public int insert(Workout workout);
    public int update(Workout workout);

}