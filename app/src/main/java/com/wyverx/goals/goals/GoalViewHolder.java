package com.wyverx.goals.goals;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wyverx.goals.R;
import com.wyverx.goals.data.model.Goal;

public class GoalViewHolder extends RecyclerView.ViewHolder {

    private final TextView goalNameTextView;
    private final TextView goalDateTextView;


    GoalViewHolder(View view) {
        super(view);
        final View item = view;
        goalNameTextView = item.findViewById(R.id.text_view_goal_name);
        goalDateTextView = item.findViewById(R.id.text_view_goal_date);
    }


    void bind(Goal goal) {
        goalNameTextView.setText(goal.getGoalName());
        goalDateTextView.setText(goal.getGoalDate());
    }
}
