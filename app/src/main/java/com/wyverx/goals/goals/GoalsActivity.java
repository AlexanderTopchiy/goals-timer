package com.wyverx.goals.goals;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wyverx.goals.R;
import com.wyverx.goals.addgoal.AddGoalActivity;
import com.wyverx.goals.data.GoalsRepository;

public class
GoalsActivity extends AppCompatActivity {

    private TextView nothingTextView;
    private RecyclerView recyclerView;
    private GoalRecyclerViewAdapter rvAdapter;
    private GoalsRepository goalsRepository;
    private static final int ADD_GOAL_INTENT_ID = 1;
    private static final String GOAL_NAME_KEY = "goal_name";
    private static final String GOAL_DATE_KEY = "goal_date";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        setTitle(R.string.my_goals);

        initUI();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intentFromAddGoal) {
        super.onActivityResult(requestCode, resultCode, intentFromAddGoal);

        if (requestCode == ADD_GOAL_INTENT_ID) {
            if (resultCode == RESULT_OK) {
                nothingTextView = findViewById(R.id.text_view_nothing);
                nothingTextView.setVisibility(View.GONE);
                goalsRepository.addNewGoalToList(
                        intentFromAddGoal.getStringExtra(GOAL_NAME_KEY),
                        intentFromAddGoal.getLongExtra(GOAL_DATE_KEY, 0));
                rvAdapter.updateDataSet(goalsRepository.getGoalsList());
            }
        }
    }


    private void initUI() {
        goalsRepository = GoalsRepository.newInstance();

        recyclerView = findViewById(R.id.rv_goals_list);
        rvAdapter = new GoalRecyclerViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(GoalsActivity.this));
        recyclerView.setAdapter(rvAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addGoalIntent = new Intent(GoalsActivity.this, AddGoalActivity.class);
                startActivityForResult(addGoalIntent, ADD_GOAL_INTENT_ID);
            }
        });
    }
}
