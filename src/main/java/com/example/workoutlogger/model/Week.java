package com.example.workoutlogger.model;

import java.util.ArrayList;
import java.util.List;

public class Week {
    // Brainstorm area for this entity:
    // In a given week, A client will have:
    // 1) several workouts
    // 2) Each workout containing exercises
    // 3) A variable to determine the progress, like a bool var of whether it is done or not
    // We want to have a check somewhere where if all the workouts in the week
    // have a bool status of done then we mark the week itself as done and move onto the 
    // next week

    private String id;
    private Boolean done;

    List<Workout> workouts = new ArrayList<>();

    public Week() {}

    public Week(String id, Boolean done) {
        this.id = id;
        this.done = false;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDone() {
        return this.done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public List<Workout> getWorkouts() {
        return this.workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public boolean canBeMarkedAsDone() {
        return workouts.stream().allMatch(Workout::getDone);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", done='" + getDone() + "'" +
            ", workouts='" + getWorkouts() + "'" +
            "}";
    }
}
