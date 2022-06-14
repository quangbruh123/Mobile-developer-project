package com.escodro.domain.usecase.task

interface UpdateTaskDescription {
    suspend operator fun invoke(taskId: Long, description: String)
}
