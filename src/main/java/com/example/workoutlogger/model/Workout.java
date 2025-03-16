package com.example.workoutlogger.model;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Workout implements Serializable{
    private String id;
    private String weekId;
    private String name;
    private boolean done;
    
    // Create array list of exercises that our workout will contain
    List<Exercise> exercises = new ArrayList<>();

    public Workout() {}

    public Workout(String id, String weekId, String name, boolean done) {
        this.id = id;
        this.weekId = weekId;
        this.name = name;
        this.done = false;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeekId() {
        return this.weekId;
    }

    public void setWeekId(String weekId) {
        this.weekId = weekId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public List<Exercise> getExercises() {
        return this.exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public boolean canBeMarkedAsDone() {
        return exercises.stream().allMatch(Exercise::getDone);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", weekId='" + getWeekId() + "'" +
            ", name='" + getName() + "'" +
            ", done='" + getDone() + "'" +
            ", exercises='" + getExercises() + "'" +
            "}";
    }
}
