package com.escodro.domain.usecase.task

import com.escodro.domain.interactor.AlarmInteractor
import com.escodro.domain.model.Task
import com.escodro.domain.repository.TaskRepository
import mu.KLogging

class DeleteTask(
    private val taskRepository: TaskRepository,
    private val alarmInteractor: AlarmInteractor
) {
    suspend operator fun invoke(task: Task) {
        logger.debug { "Deleting task ${task.title}" }
        taskRepository.deleteTask(task)
        alarmInteractor.cancel(task.id)
    }

    companion object : KLogging()
}
