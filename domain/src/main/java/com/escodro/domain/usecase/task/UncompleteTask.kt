package com.escodro.domain.usecase.task

import com.escodro.domain.model.Task
import com.escodro.domain.repository.TaskRepository

class UncompleteTask(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: Task) {
        val updatedTask = updateTaskAsUncompleted(task)
        return taskRepository.updateTask(updatedTask)
    }

    private fun updateTaskAsUncompleted(task: Task) =
        task.copy(completed = false, completedDate = null)
}
