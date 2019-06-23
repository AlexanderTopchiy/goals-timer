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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddGoalActivity extends AppCompatActivity {

    private TextInputEditText goalNameEditText;
    private TextInputEditText goalDateEditText;
    private Button createGoalButton;
    private Calendar calendar;
    private DatePickerDialog.OnDateSetListener dateSetListener;


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

                SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

                goalDateEditText.setText(dateFormatter.format(calendar.getTime()));
            }
        };

        createGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goalsIntent = new Intent(getApplicationContext(), GoalsActivity.class);
                boolean nameFlag = false;
                boolean dateFlag = false;
                // Check if Name edit text field is empty
                if(TextUtils.isEmpty(goalNameEditText.getText())) {
                    Toast.makeText(AddGoalActivity.this, R.string.goal_name_empty, Toast.LENGTH_SHORT).show();
                } else {
                    nameFlag = true;
                    goalsIntent.putExtra("goal name", goalNameEditText.getText());
                }
                // Check if Date edit text field is empty
                if(TextUtils.isEmpty(goalDateEditText.getText())) {
                    Toast.makeText(AddGoalActivity.this, R.string.goal_date_empty, Toast.LENGTH_SHORT).show();
                } else {
                    dateFlag = true;
                    goalsIntent.putExtra("goal date", goalDateEditText.getText());
                }
                // Only if both fields are not empty
                if (nameFlag && dateFlag) {
                    startActivity(goalsIntent);
                }
            }
        });
    }
}
