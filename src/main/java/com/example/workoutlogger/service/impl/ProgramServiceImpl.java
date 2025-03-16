package com.example.workoutlogger.service.impl;

import java.util.List;
import java.util.UUID;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.lang3.SerializationUtils;
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

    public Program createProgramDeepClone(Program program) {
        Program copiedProgram = (Program) SerializationUtils.clone(program);

        copiedProgram.setId(UUID.randomUUID().toString());

        for (Week week: copiedProgram.getWeeks()) {
            week.setId(UUID.randomUUID().toString());

            for (Workout workout: week.getWorkouts()) {
                workout.setId(UUID.randomUUID().toString());

                for (Exercise exercise: workout.getExercises()) {
                    exercise.setId(UUID.randomUUID().toString());
                }
            }
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
