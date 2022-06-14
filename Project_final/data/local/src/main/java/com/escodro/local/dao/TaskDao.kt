package com.escodro.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.escodro.local.model.Task

@Dao
interface TaskDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("DELETE FROM task")
    suspend fun cleanTable()

    @Query("SELECT * FROM task where task_due_date is not null")
    suspend fun findAllTasksWithDueDate(): List<Task>

    @Query("SELECT * FROM task WHERE task_id = :taskId")
    suspend fun getTaskById(taskId: Long): Task?
}
