package com.example.workoutlogger.model;

import java.util.ArrayList;
import java.util.List;

public class UserWeekStatus {
    private String userId;
    private String weekId;
    private String programId;
    private boolean done;
    private String notes;

    List<UserWorkoutStatus> userWorkoutStatus = new ArrayList<>();

    public UserWeekStatus() {}

    public UserWeekStatus(String userId, String weekId, String programId, String notes) {
        this.userId = userId;
        this.weekId = weekId;
        this.programId = programId;
        this.done = false;
        this.notes = notes;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWeekId() {
        return this.weekId;
    }

    public void setWeekId(String weekId) {
        this.weekId = weekId;
    }

    public String getProgramId() {
        return this.programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
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
        return userWorkoutStatus.stream().allMatch(UserWorkoutStatus::getDone);
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", weekId='" + getWeekId() + "'" +
            ", programId='" + getProgramId() + "'" +
            ", done='" + getDone() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }

}
