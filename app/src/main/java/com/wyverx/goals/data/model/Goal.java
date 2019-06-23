package com.wyverx.goals.data.model;

public class Goal {

    private String goalName;
    private String goalDate;


    public Goal(String goalName, String goalDate) {
        this.goalName = goalName;
        this.goalDate = goalDate;
    }


    public String getGoalName() {
        return goalName;
    }

    public String getGoalDate() {
        return goalDate;
    }
}
