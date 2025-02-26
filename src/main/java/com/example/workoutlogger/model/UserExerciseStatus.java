package com.example.workoutlogger.model;

public class UserExerciseStatus {
    private String userId;
    private String exerciseId;
    private String workoutId;
    private boolean done;
    private int repsDone;
    private float weightUsed;
    private int setsDone;
    private String notes;

    public UserExerciseStatus() {}

    public UserExerciseStatus(String userId, String exerciseId, String workoutId, int repsDone, float weightUsed, int setsDone, String notes) {
        this.userId = userId;
        this.exerciseId = exerciseId;
        this.workoutId = workoutId;
        this.done = false;
        this.repsDone = repsDone;
        this.weightUsed = weightUsed;
        this.setsDone = setsDone;
        this.notes = notes;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExerciseId() {
        return this.exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getWorkoutId() {
        return this.workoutId;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }

    public boolean getDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getRepsDone() {
        return this.repsDone;
    }

    public void setRepsDone(int repsDone) {
        this.repsDone = repsDone;
    }

    public float getWeightUsed() {
        return this.weightUsed;
    }

    public void setWeightUsed(float weightUsed) {
        this.weightUsed = weightUsed;
    }

    public int getSetsDone() {
        return this.setsDone;
    }

    public void setSetsDone(int setsDone) {
        this.setsDone = setsDone;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", exerciseId='" + getExerciseId() + "'" +
            ", done='" + getDone() + "'" +
            ", repsDone='" + getRepsDone() + "'" +
            ", weightUsed='" + getWeightUsed() + "'" +
            ", setsDone='" + getSetsDone() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}