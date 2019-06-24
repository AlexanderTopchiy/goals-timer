package com.wyverx.goals.addgoal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.wyverx.goals.R;
import com.wyverx.goals.goals.GoalsActivity;
import com.wyverx.goals.utils.DateUtils;

import java.util.Calendar;
import java.util.Date;

public class AddGoalActivity extends AppCompatActivity {

    private TextInputEditText goalNameEditText;
    private TextInputEditText goalDateEditText;
    private Button createGoalButton;

    private Calendar calendar;
    private Date goalDate;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    private static final String GOAL_NAME_KEY = "goal_name";
    private static final String GOAL_DATE_KEY = "goal_date";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);

        setTitle(R.string.create_goal);

        initUI();
    }


    private void initUI() {
        goalNameEditText = findViewById(R.id.edit_text_goal_name);
        goalDateEditText = findViewById(R.id.edit_text_goal_date);
        createGoalButton = findViewById(R.id.button_create_goal);
        calendar = Calendar.getInstance();

        goalDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(
                        AddGoalActivity.this,
                        dateSetListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                goalDate = calendar.getTime();

                goalDateEditText.setText(DateUtils.dateFormatter(goalDate));
            }
        };

        createGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goalsIntent = new Intent(getApplicationContext(), GoalsActivity.class);
                boolean nameFlag = false;
                boolean dateFlag = false;
                // Check if Name edit text field is empty
                if (TextUtils.isEmpty(goalNameEditText.getText())) {
                    Toast.makeText(AddGoalActivity.this, R.string.goal_name_empty, Toast.LENGTH_SHORT).show();
                } else {
                    goalsIntent.putExtra(GOAL_NAME_KEY, goalNameEditText.getText().toString());
                    nameFlag = true;
                }
                // Check if Date edit text field is empty
                if (TextUtils.isEmpty(goalDateEditText.getText())) {
                    Toast.makeText(AddGoalActivity.this, R.string.goal_date_empty, Toast.LENGTH_SHORT).show();
                } else {
                    goalsIntent.putExtra(GOAL_DATE_KEY, goalDate.getTime());
                    dateFlag = true;
                }
                // Only if both fields are not empty
                if (nameFlag && dateFlag) {
                    setResult(RESULT_OK, goalsIntent);
                    finish();
                }
            }
        });
    }
}
