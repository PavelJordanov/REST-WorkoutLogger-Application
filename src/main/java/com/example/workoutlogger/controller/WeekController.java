package com.example.workoutlogger.controller;

import com.example.workoutlogger.model.Week;
import com.example.workoutlogger.service.WeekService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/week")
public class WeekController {
    @Autowired
    WeekService weekService;

    @GetMapping
    public ResponseEntity<List<Week>> getWeeks() {
        System.out.println("Here!");
        return ResponseEntity.ok(weekService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Week> getWeekById(@PathVariable String id) {
        Week week = weekService.findById(id);
        if (week == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(week);
        }
    }

    @PostMapping
    public ResponseEntity<Week> saveWeek(@RequestBody Week week) {
        week.setId(UUID.randomUUID().toString());
        weekService.insert(week);
        return ResponseEntity.status(HttpStatus.CREATED).body(week);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Week> updateWeekById(@PathVariable String id, @RequestBody Week week) {
        week.setId(id);
        weekService.update(week);
        return ResponseEntity.ok(week);
    }

    @PutMapping("/{id}/mark-done")
    public ResponseEntity<String> markWeekAsDone(@PathVariable String id) {
        try {
            weekService.markWeekAsDone(id);
            return ResponseEntity.ok("Week marked as done!");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeekById(@PathVariable String id) {
        weekService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
