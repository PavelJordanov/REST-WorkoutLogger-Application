package com.example.workoutlogger.model;

import java.util.ArrayList;
import java.util.List;

public class UserWorkoutStatus {
    private String userId;
    private String workoutId;
    private String weekId;
    private boolean done;
    private String notes;

    List<UserExerciseStatus> userExerciseStatus = new ArrayList<>();

    public UserWorkoutStatus() {}

    public UserWorkoutStatus(String userId, String workoutId, String weekId, String notes) {
        this.userId = userId;
        this.workoutId = workoutId;
        this.weekId = weekId;
        this.done = false;
        this.notes = notes;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWorkoutId() {
        return this.workoutId;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }

    public String getWeekId() {
        return this.weekId;
    }

    public void setWeekId(String weekId) {
        this.weekId = weekId;
    }

    public boolean getDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean canBeMarkedAsDone() {
        return userExerciseStatus.stream().allMatch(UserExerciseStatus::getDone);
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", workoutId='" + getWorkoutId() + "'" +
            ", weekId='" + getWeekId() + "'" +
            ", done='" + getDone() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}
