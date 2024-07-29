package com.yourpackage;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddTodoActivity extends AppCompatActivity {

    private EditText taskTitle;
    private EditText taskDescription;
    private Button dueDateButton;
    private Spinner prioritySpinner;
    private Button addTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo);

        taskTitle = findViewById(R.id.task_title);
        taskDescription = findViewById(R.id.task_description);
        dueDateButton = findViewById(R.id.due_date_button);
        prioritySpinner = findViewById(R.id.priority_spinner);
        addTaskButton = findViewById(R.id.add_task_button);

        dueDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dueDateButton.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },
                year, month, day);
        datePickerDialog.show();
    }

    private void addTask() {
        String title = taskTitle.getText().toString();
        String description = taskDescription.getText().toString();
        String dueDate = dueDateButton.getText().toString();
        String priority = prioritySpinner.getSelectedItem().toString();

        // Add the logic to save the task
    }
