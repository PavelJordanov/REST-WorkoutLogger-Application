package com.example.workoutlogger.controller;

import com.example.workoutlogger.model.Program;
import com.example.workoutlogger.service.ProgramService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/program")
public class ProgramController {
    @Autowired
    ProgramService programService;

    @GetMapping
    public ResponseEntity<List<Program>> getPrograms() {
        System.out.println("Here!");
        return ResponseEntity.ok(programService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Program> getProgramById(@PathVariable String id) {
        Program program = programService.findById(id);
        if (program == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(program);
        }
    }

    @PostMapping
    public ResponseEntity<Program> saveProgram(@RequestBody Program program) {
        program.setId(UUID.randomUUID().toString());
        programService.insert(program);
        return ResponseEntity.status(HttpStatus.CREATED).body(program);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Program> updateProgramById(@PathVariable String id, @RequestBody Program program) {
        program.setId(id);
        programService.update(program);
        return ResponseEntity.ok(program);
    }

    @PutMapping("/{id}/mark-done")
    public ResponseEntity<String> markProgramAsDone(@PathVariable String id) {
        try {
            programService.markProgramAsDone(id);
            return ResponseEntity.ok("Program marked as done!");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramById(@PathVariable String id) {
        programService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
