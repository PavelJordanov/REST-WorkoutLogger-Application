package com.example.workoutlogger.model;

import java.util.ArrayList;
import java.util.List;


public class Workout {
    private String id;
    private String name;
    private Boolean done;
    
    // Create array list of exercises that our workout will contain
    List<Exercise> exercises = new ArrayList<>();

    public Workout() {}

    public Workout(String id, String name, Boolean done) {
        this.id = id;
        this.name = name;
        this.done = false;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExercises() {
        return this.exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public void removeExercise(Exercise exercise) {
            exercises.remove(exercise);
    }

    public Boolean getDone() {
        return this.done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", exercises='" + getExercises() + "'" +
            ", done='" + getDone() + "'" +
            "}";
    }
}
