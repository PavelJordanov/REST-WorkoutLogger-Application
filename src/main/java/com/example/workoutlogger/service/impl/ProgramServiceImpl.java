package com.example.workoutlogger.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.io.IOException;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.lang3.SerializationUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workoutlogger.model.Program;
import com.example.workoutlogger.repository.ProgramRepository;
import com.example.workoutlogger.service.ProgramService;
import com.example.workoutlogger.model.Week;
import com.example.workoutlogger.repository.WeekRepository;
import com.example.workoutlogger.service.WeekService;
import com.example.workoutlogger.model.Workout;
import com.example.workoutlogger.repository.WorkoutRepository;
import com.example.workoutlogger.service.WorkoutService;
import com.example.workoutlogger.model.Exercise;
import com.example.workoutlogger.repository.ExerciseRepository;
import com.example.workoutlogger.service.ExerciseService;


@Service
public class ProgramServiceImpl implements ProgramService, Serializable{
    @Autowired
    ProgramRepository programRepository;
    @Autowired
    WeekRepository weekRepository;
    @Autowired
    WorkoutRepository workoutRepository;
    @Autowired
    ExerciseRepository exerciseRepository;

    public List<Program> findAll() {
        return programRepository.findall();
    }

    public Program findById(String id) {
        return programRepository.findById(id);
    }

    public void deleteById(String id) {
        programRepository.deleteById(id);
    }

    public int insert(Program program) {
        int result = programRepository.insert(program);
        return result;
    }

    public int update(Program program) {
        return programRepository.update(program);
    }

    @Override
    @Transactional
    public Program cloneAndInsertProgram(String id) {
        //Find the original
        Program original = programRepository.findByIdFull(id);
        if (original == null) {
            throw new IllegalArgumentException("Program with id=" + id + " not found.");
        }

        // Deep clone the original
        Program cloned = createProgramDeepClone(original);

        // Insert the top-level Program row
        programRepository.insert(cloned);

        // Insert the nested objects in batches
        
        // Insert Weeks
        weekRepository.batchInsert(cloned.getWeeks(), cloned.getId());
        
        // For each Week, batch-insert Workouts

        List<Week> weeks = cloned.getWeeks();
        List<Workout> workouts = cloned.getWeeks().stream().flatMap(week -> week.getWorkouts().stream()).toList();

        workoutRepository.batchInsert(weeks);
        exerciseRepository.batchInsert(workouts);

        // Return the fully cloned Program
        return cloned;
    }

    public Program createProgramDeepClone(Program program) {
        ObjectMapper objectMapper = new ObjectMapper();
        Program copiedProgram = null;
        try {
            // 1) Serialize the original Program to JSON
            String jsonString = objectMapper.writeValueAsString(program);

            // 2) Deserialize JSON back into a new Program object
            copiedProgram = objectMapper.readValue(jsonString, Program.class);

            // 3) Assign new IDs to the cloned Program and all nested objects
            copiedProgram.setId(UUID.randomUUID().toString());
            for (Week week : copiedProgram.getWeeks()) {
                week.setId(UUID.randomUUID().toString());
                for (Workout workout : week.getWorkouts()) {
                    workout.setId(UUID.randomUUID().toString());
                    for (Exercise exercise : workout.getExercises()) {
                        exercise.setId(UUID.randomUUID().toString());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // handle or rethrow as needed
        }

        return copiedProgram;
    }
    
    public void markProgramAsDone(String id) {
        Program program = programRepository.findById(id);

        if (program.canBeMarkedAsDone()) {
            program.setDone(true);
            programRepository.update(program);
        } else {
            throw new IllegalStateException("Not all weeks are done yet!");
        }
    }
}
