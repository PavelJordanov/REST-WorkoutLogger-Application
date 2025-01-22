package com.example.workoutlogger.service.impl;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.workoutlogger.model.Exercise;
import com.example.workoutlogger.repository.ExerciseRepository;
import com.example.workoutlogger.service.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService{
    @Autowired
    ExerciseRepository exerciseRepository;

    public List<Exercise> findAll() {
        return exerciseRepository.findall();
    }

    public Exercise findById(String id) {
        return exerciseRepository.findById(id);
    }

    public void deleteById(String id) {
        exerciseRepository.deleteById(id);
    }


}
