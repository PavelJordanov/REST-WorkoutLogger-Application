package com.example.workoutlogger.model;

import java.util.ArrayList;
import com.example.workoutlogger.model.Exercise;

public class Workout {
    private String id;
    private String name;
    
    // Create array list of exercises that our workout will contain
    List<Exercise> exercises = new ArrayList<>();

    public Workout() {}

    public Workout(String id, String name) {
        this.id = id;
        this.name = name;
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

    public ArrayList<Exercise> getExercises() {
        return this.exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public void removeExercise(Exercise exercise) {
            exercises.remove(exercise);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", exercises='" + getExercises() + "'" +
            "}";
    }
}
