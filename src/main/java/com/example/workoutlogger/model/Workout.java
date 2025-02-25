package com.example.workoutlogger.model;

import java.util.ArrayList;
import java.util.List;


public class Workout {
    private String id;
    private String name;
    private boolean done;
    
    // Create array list of exercises that our workout will contain
    List<Exercise> exercises = new ArrayList<>();

    public Workout() {}

    public Workout(String id, String name, boolean done) {
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

    public boolean getDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean canBeMarkedAsDone() {
        return exercises.stream().allMatch(Exercise::getDone);
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
