package com.example.workoutlogger.model;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Program implements Serializable{
    private String id;
    private String name;
    private boolean done;

    List<Week> weeks = new ArrayList<>();

    public Program() {}

    public Program(String id, String name, boolean done) {
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

    public boolean getDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public List<Week> getWeeks() {
        return this.weeks;
    }

    public void setWeeks(List<Week> weeks) {
        this.weeks = weeks;
    }

    public boolean canBeMarkedAsDone() {
        return weeks.stream().allMatch(Week::getDone);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", done='" + getDone() + "'" +
            ", weeks='" + getWeeks() + "'" +
            "}";
    }
}
