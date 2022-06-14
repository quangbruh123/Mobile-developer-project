package com.escodro.domain.usecase.task

interface UpdateTaskCategory {
    suspend operator fun invoke(taskId: Long, categoryId: Long?)
}
