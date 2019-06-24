package com.wyverx.goals.data.model;

public class Goal {

    private String goalName;
    private long goalDate;


    public Goal(String goalName, long goalDate) {
        this.goalName = goalName;
        this.goalDate = goalDate;
    }


    public String getGoalName() {
        return goalName;
    }

    public long getGoalDate() {
        return goalDate;
    }
}
