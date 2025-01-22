package com.example.workoutlogger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workoutlogger.model.Exercise;
import com.example.workoutlogger.service.ExerciseService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<Exercise>> getExercises() {
        System.out.println("Here!");
        return ResponseEntity.ok(exerciseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable String id) {
        Exercise exercise = exerciseService.findById(id);
        if (exercise == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(exercise);
        }
    }

    @PostMapping
    public ResponseEntity<Exercise> saveExercise(@RequestBody Exercise exercise) {
        exercise.setId(UUID.randomUUID().toString());
        exerciseService.insert(exercise);
        return ResponseEntity.status(HttpStatus.CREATED).body(exercise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercise> updateExerciseById(@PathVariable String id, @RequestBody Exercise exercise) {
        exercise.setId(id);
        exerciseService.update(exercise);
        return ResponseEntity.ok(exercise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExerciseById(@PathVariable String id) {
        exerciseService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
