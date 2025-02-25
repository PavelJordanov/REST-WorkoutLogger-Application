package com.example.workoutlogger.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.workoutlogger.model.Week;
import com.example.workoutlogger.repository.WeekRepository;
import com.example.workoutlogger.service.WeekService;

@Service
public class WeekServiceImpl implements WeekService {
    
    @Autowired
    WeekRepository weekRepository;

    public List<Week> findAll() {
        return weekRepository.findall();
    }

    public Week findById(String id) {
        return weekRepository.findById(id);
    }

    public void deleteById(String id) {
        weekRepository.deleteById(id);
    }

    public int insert(Week week) {
        int result = weekRepository.insert(week);
        return result;
    }

    public int update(Week week) {
        return weekRepository.update(week);
    }
    
    public void markWeekAsDone(String id) {
        Week week = weekRepository.findById(id);

        if (week.canBeMarkedAsDone()) {
            week.setDone(true);
            weekRepository.update(week);
        } else {
            throw new IllegalStateException("Not all exercises are done yet!");
        }
    }
}
