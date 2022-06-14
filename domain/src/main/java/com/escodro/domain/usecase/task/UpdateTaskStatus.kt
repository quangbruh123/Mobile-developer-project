package com.escodro.domain.usecase.task

interface UpdateTaskStatus {
    suspend operator fun invoke(taskId: Long)
}
