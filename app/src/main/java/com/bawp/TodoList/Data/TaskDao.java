package com.bawp.TodoList.Data;

import android.view.inspector.PropertyMapper;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.bawp.TodoList.Model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insertTask(Task task);

    @Query("DELETE FROM TASK_TABLE")
    void deleteAll();

    @Query("SELECT * FROM TASK_TABLE")
    LiveData<List<Task>> getTasks();

    @Query("SELECT * FROM TASK_TABLE WHERE Task_Id == :id")
    LiveData<Task> get(long id);

    @Update
    void update(Task task);

    @Delete
    void delete(Task task);
}
