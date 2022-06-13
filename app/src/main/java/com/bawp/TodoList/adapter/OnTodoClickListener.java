package com.bawp.TodoList.adapter;

import com.bawp.TodoList.Model.Task;

public interface OnTodoClickListener {
    void onTodoClick(Task task);
    void onTodoRadioButtonCLick(Task task);
}
