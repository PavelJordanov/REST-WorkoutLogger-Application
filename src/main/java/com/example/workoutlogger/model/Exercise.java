package com.example.workoutlogger.model;

public class Exercise {
    private String id;
    private String name;
    private int sets;
    private int reps;
    private float weight;
    private String workout;

    public Exercise() {}

    public Exercise(String id, String name, int sets, int reps, float weight, String workout) {
        this.id = id;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.workout = workout;
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

    public String getWorkout() {
        return this.workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", sets='" + getSets() + "'" +
            ", reps='" + getReps() + "'" +
            ", weight='" + getWeight() + "'" +
            "}";
    }
}