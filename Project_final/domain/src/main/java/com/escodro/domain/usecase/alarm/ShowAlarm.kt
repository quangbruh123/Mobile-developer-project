package com.escodro.domain.usecase.alarm

import com.escodro.domain.interactor.NotificationInteractor
import com.escodro.domain.repository.TaskRepository
import mu.KLogging

class ShowAlarm(
    private val taskRepository: TaskRepository,
    private val notificationInteractor: NotificationInteractor,
    private val scheduleNextAlarm: ScheduleNextAlarm
) {
    suspend operator fun invoke(taskId: Long) {
        val task = taskRepository.findTaskById(taskId) ?: return

        if (task.completed) {
            logger.debug { "Task '${task.title}' is already completed. Will not notify" }
            return
        } else {
            logger.debug { "Notifying task '${task.title}'" }
            notificationInteractor.show(task)
        }

        if (task.isRepeating) {
            scheduleNextAlarm(task)
        }
    }

    companion object : KLogging()
}
