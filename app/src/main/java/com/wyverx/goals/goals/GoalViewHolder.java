package com.wyverx.goals.goals;

import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wyverx.goals.R;
import com.wyverx.goals.data.model.Goal;

import java.util.Date;

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

        long goalDate = goal.getGoalDate();
        Date today = new Date();
        long currentTime = today.getTime();
        long expiryTime = goalDate - currentTime;

        new CountDownTimer(expiryTime, 50) {
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;
                long minutes = seconds / 60;
                long hours = minutes / 60;
                long days = hours / 24;
                String time = "Осталось " + days +" дн. " + "и "
                        + hours % 24 + ":" + minutes % 60 + ":"
                        + seconds % 60 + ":" + millisUntilFinished % 1000;
                goalDateTextView.setText(time);
            }

            public void onFinish() {
                goalDateTextView.setText(R.string.text_goals_done);
            }
        }.start();
    }
}
