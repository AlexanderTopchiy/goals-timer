package com.wyverx.goals.data;

import com.wyverx.goals.data.model.Goal;

import java.util.ArrayList;
import java.util.List;

public class GoalsRepository {

    private List<Goal> goalsList;


    private GoalsRepository() {
        goalsList = new ArrayList<>();
    }


    public static GoalsRepository newInstance() {
        return new GoalsRepository();
    }


    public List<Goal> getGoalsList() {
        return goalsList;
    }


    public void addNewGoalToList(String goalName, long goalDate) {
        goalsList.add(new Goal(goalName, goalDate));
    }
}
