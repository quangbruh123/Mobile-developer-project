package com.bawp.TodoList.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "TASK_TABLE")
public class Task {
    @ColumnInfo(name = "Task_Id")
    @PrimaryKey(autoGenerate = true)
    public long taskId;

    public String task;

    public Priority priority;

    @ColumnInfo(name = "due_date")
    public Date dueDate;

    @ColumnInfo(name = "created_at")
    public Date dateCreate;

    public boolean isDone;

    public Task (String task, Priority priority, Date dueDate, Date dateCreate, boolean isDone) {
        this.task = task;
        this.priority = priority;
        this.dueDate = dueDate;
        this.dateCreate = dateCreate;
        this.isDone = isDone;
    }

    public long getTaskId() {
        return taskId;
    }

    public String getTask() {
        return task;
    }

    public Priority getPriority() {
        return priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.task = taskName;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Task {" +
                "taskId: " + taskId +
                ", task: '" + task+ '\'' +
                ", priority: " + priority +
                ", due date: " + dueDate +
                ", date created: " + dateCreate +
                ", state: " + (isDone == true ? "Done" : "Not done");
    }
}