package com.wyverx.goals.goals;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyverx.goals.R;
import com.wyverx.goals.data.model.Goal;

import java.util.ArrayList;
import java.util.List;

public class GoalRecyclerViewAdapter extends RecyclerView.Adapter<GoalViewHolder> {

    private List<Goal> goalsList = new ArrayList<>();


    @NonNull
    @Override
    public GoalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_goals_list_item, parent, false);

        return new GoalViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull GoalViewHolder holder, int position) {
        Goal goal = goalsList.get(position);
        holder.bind(goal);
    }


    @Override
    public int getItemCount() {
        return goalsList.size();
    }


    public void updateDataSet(List<Goal> goals) {
        this.goalsList.clear();
        this.goalsList.addAll(goals);
        notifyDataSetChanged();
    }
}
