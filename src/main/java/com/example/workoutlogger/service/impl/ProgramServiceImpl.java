package com.example.workoutlogger.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.workoutlogger.model.Program;
import com.example.workoutlogger.repository.ProgramRepository;
import com.example.workoutlogger.service.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService{
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
