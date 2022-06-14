package com.escodro.domain.repository

import com.escodro.domain.model.Task

interface TaskRepository {
    suspend fun insertTask(task: Task)
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun cleanTable()
    suspend fun findAllTasksWithDueDate(): List<Task>
    suspend fun findTaskById(taskId: Long): Task?
}
