package com.example.workoutlogger.model;

import java.io.Serializable;

public class Exercise implements Serializable{
    private String id;
    private String workoutId;
    private String name;
    private int sets;
    private int reps;
    private float weight;
    private boolean done;

    public Exercise() {}

    public Exercise(String id, String workoutId, String name, int sets, int reps, float weight, boolean done) {
        this.id = id;
        this.workoutId = workoutId;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.done = false;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkoutId() {
        return this.workoutId;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSets() {
        return this.sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return this.reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public float getWeight() {
        return this.weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean getDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", workoutId='" + getWorkoutId() + "'" +
            ", name='" + getName() + "'" +
            ", sets='" + getSets() + "'" +
            ", reps='" + getReps() + "'" +
            ", weight='" + getWeight() + "'" +
            ", done='" + getDone() + "'" +
            "}";
    }
}