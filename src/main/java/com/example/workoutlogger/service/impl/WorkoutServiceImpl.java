package com.example.workoutlogger.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.workoutlogger.model.Workout;
import com.example.workoutlogger.repository.WorkoutRepository;
import com.example.workoutlogger.service.WorkoutService;

@Service
public class WorkoutServiceImpl implements WorkoutService{
    @Autowired
    WorkoutRepository workoutRepository;

    public List<Workout> findAll() {
        return workoutRepository.findall();
    }

    public Workout findById(String id) {
        return workoutRepository.findById(id);
    }

    public void deleteById(String id) {
        workoutRepository.deleteById(id);
    }

    public int insert(Workout workout) {
        int result = workoutRepository.insert(workout);

        return result;
    }

    public int update(Workout workout) {
        return workoutRepository.update(workout);
    }
}
