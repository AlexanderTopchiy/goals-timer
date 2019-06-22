package com.wyverx.goals.goals;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wyverx.goals.R;
import com.wyverx.goals.addgoal.AddGoalActivity;

public class GoalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        setTitle(R.string.my_goals);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addGoalIntent = new Intent(getApplicationContext(), AddGoalActivity.class);
                startActivity(addGoalIntent);
            }
        });
    }
}
