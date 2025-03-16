package com.example.workoutlogger.controller;

import com.example.workoutlogger.model.Workout;
import com.example.workoutlogger.service.WorkoutService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/workout")
public class WorkoutController {
    @Autowired
    WorkoutService workoutService;

    @GetMapping
    public ResponseEntity<List<Workout>> getWorkouts() {
        System.out.println("Here!");
        return ResponseEntity.ok(workoutService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable String id) {
        Workout workout = workoutService.findById(id);
        if (workout == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(workout);
        }
    }

    @PostMapping
    public ResponseEntity<Workout> saveWorkout(@RequestBody Workout workout) {
        workout.setId(UUID.randomUUID().toString());
        workoutService.insert(workout);
        return ResponseEntity.status(HttpStatus.CREATED).body(workout);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workout> updateWorkoutById(@PathVariable String id, @RequestBody Workout workout) {
        workout.setId(id);
        workoutService.update(workout);
        return ResponseEntity.ok(workout);
    }

    @PutMapping("/{id}/mark-done")
    public ResponseEntity<String> markWorkoutAsDone(@PathVariable String id) {
        try {
            workoutService.markWorkoutAsDone(id);
            return ResponseEntity.ok("Workout marked as done!");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutById(@PathVariable String id) {
        workoutService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
