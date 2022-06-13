package com.bawp.TodoList.adapter;

import com.bawp.TodoList.Model.Task;

public interface OnTodoClickListener {
    void onTodoClick(int adapterPosition, Task task);
}
