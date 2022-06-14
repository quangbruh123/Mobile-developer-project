package com.escodro.domain.usecase.task

interface UpdateTaskTitle {
    suspend operator fun invoke(taskId: Long, title: String)
}
