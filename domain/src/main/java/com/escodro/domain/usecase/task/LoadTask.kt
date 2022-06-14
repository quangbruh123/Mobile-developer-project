package com.escodro.domain.usecase.task

import com.escodro.domain.model.Task

interface LoadTask {
    suspend operator fun invoke(taskId: Long): Task?
}
