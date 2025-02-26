package com.example.workoutlogger.model;

import java.util.ArrayList;
import java.util.List;

public class UserProgramStatus {
    private String userId;
    private String programId;
    private boolean done;
    private String notes;

    List<UserWeekStatus> userWeekStatus = new ArrayList<>();

    public UserProgramStatus() {}

    public UserProgramStatus(String userId, String programId, String notes) {
        this.userId = userId;
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
        return userWeekStatus.stream().allMatch(UserWeekStatus::getDone);
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", programId='" + getProgramId() + "'" +
            ", done='" + getDone() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}
