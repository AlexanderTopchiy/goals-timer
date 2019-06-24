package com.wyverx.goals.goals;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wyverx.goals.R;
import com.wyverx.goals.data.model.Goal;

public class GoalViewHolder extends RecyclerView.ViewHolder {

    private TextView goalNameTextView;
    private TextView goalDateTextView;


    GoalViewHolder(View view) {
        super(view);
        goalNameTextView = view.findViewById(R.id.text_view_goal_name);
        goalDateTextView = view.findViewById(R.id.text_view_goal_date);
    }


    void bind(Goal goal) {
        goalNameTextView.setText(goal.getGoalName());
        goalDateTextView.setText(goal.getGoalDate());
    }
}
