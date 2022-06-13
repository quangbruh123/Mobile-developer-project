package com.bawp.TodoList;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawp.TodoList.Model.Priority;
import com.bawp.TodoList.Model.SharedViewModel;
import com.bawp.TodoList.Model.Task;
import com.bawp.TodoList.Model.TaskViewModel;
import com.bawp.TodoList.util.Utils;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.chip.Chip;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.ViewModelProvider;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private EditText enterTodo;
    private ImageButton calenderButton;
    private ImageButton priorityButton;
    private ImageButton clockButton;
    private ImageButton saveButton;
    private RadioGroup priorityRadioGroup;
    private RadioButton selectedRadioButton;
    private int selectedButtonId;
    private CalendarView calendarView;
    private Group calenderGroup;
    Calendar calendar = Calendar.getInstance();
    private int[] time;
    private Date dueDate;
    private SharedViewModel sharedViewModel;
    private boolean isEdit;
    private Priority priority;
    public BottomSheetFragment() {

    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.bottom_sheet, container, false);
        calenderGroup = view.findViewById(R.id.calendar_group);
        calendarView = view.findViewById(R.id.calendar_view);
        calenderButton = view.findViewById(R.id.today_calendar_button);
        enterTodo = view.findViewById(R.id.enter_todo_et);
        saveButton = view.findViewById(R.id.save_todo_button);
        priorityButton = view.findViewById(R.id.priority_todo_button);
        priorityRadioGroup = view.findViewById(R.id.radioGroup_priority);
        clockButton = view.findViewById(R.id.time_button);

        Chip todayChip = view.findViewById(R.id.today_chip);
        todayChip.setOnClickListener(this);
        Chip tomorrowChip = view.findViewById(R.id.tomorrow_chip);
        tomorrowChip.setOnClickListener(this);
        Chip nextweekChip = view.findViewById(R.id.next_week_chip);
        nextweekChip.setOnClickListener(this);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity())
                .get(SharedViewModel.class);

        calenderButton.setOnClickListener(view1 -> {
            calenderGroup.setVisibility(calenderGroup.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            Utils.hideSoftKeyboard(view1);
        });

        calendarView.setOnDateChangeListener((calendarView, year, month, dayOfMonth) -> {
            calendar.clear();
            calendar.set(year, month, dayOfMonth);
            dueDate = calendar.getTime();
        });

        priorityButton.setOnClickListener(view1 -> {
            Utils.hideSoftKeyboard(view1);
            priorityRadioGroup.setVisibility(priorityRadioGroup.getVisibility() == View.GONE ?  View.VISIBLE : View.GONE);
            priorityRadioGroup.setOnCheckedChangeListener(((radioGroup, checkedId) -> {
                if (priorityRadioGroup.getVisibility() == View.VISIBLE) {
                    selectedButtonId = checkedId;
                    selectedRadioButton = view.findViewById(selectedButtonId);
                    if (selectedRadioButton.getId() == R.id.radioButton_high)
                        priority = Priority.HIGH;
                    else if (selectedRadioButton.getId() == R.id.radioButton_med)
                        priority = Priority.MEDIUM;
                    else if (selectedRadioButton.getId() == R.id.radioButton_low)
                        priority = Priority.LOW;
                    else
                        priority = Priority.LOW;
                }
            } ));
        });

        saveButton.setOnClickListener(view1 -> {
            String task = enterTodo.getText().toString().trim();

            if (!TextUtils.isEmpty(task) && dueDate != null && priority != null) {
                Task newtask = new Task(task, priority, dueDate,
                        Calendar.getInstance().getTime(), false);
                if (isEdit) {
                    Task updatedTask = sharedViewModel.getSelectedItem().getValue();
                    updatedTask.setTaskName(task);
                    updatedTask.setDateCreate(Calendar.getInstance().getTime());
                    updatedTask.setDueDate(dueDate);
                    updatedTask.setPriority(priority);
                    TaskViewModel.update(updatedTask);
                    sharedViewModel.setIsEdit(false);
                }
                else {
                    TaskViewModel.insert(newtask);
                }
                enterTodo.setText("");
                if (this.isVisible()) {
                    this.dismiss();
                }
            }
            else {
                Snackbar.make(saveButton, R.string.empty_field,Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private boolean CheckEnoughTime() {
        for (int i = 0; i < time.length; i++) {
            if (time == null) {
                Log.d("Return", "return");
                return false;
            }
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.today_chip) {
            calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, 0);
            dueDate = calendar.getTime();
            Log.d("TIME", "onClick" + dueDate.toString());
        }
        else if (id == R.id.tomorrow_chip) {
            calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            dueDate = calendar.getTime();
            Log.d("TIME", "onClick" + dueDate.toString());
        }
        else if (id == R.id.next_week_chip) {
            calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, 7);
            dueDate = calendar.getTime();
            Log.d("TIME", "onClick" + dueDate.toString());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (sharedViewModel.getSelectedItem().getValue() != null) {
            isEdit = sharedViewModel.getIsEdit();

            Task task = sharedViewModel.getSelectedItem().getValue();
            if (isEdit)
                enterTodo.setText(task.getTask());
            else enterTodo.setText("");
        }
    }
}