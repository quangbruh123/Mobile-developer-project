package com.escodro.domain.usecase.task

import com.escodro.domain.model.Task

interface AddTask {
    suspend operator fun invoke(task: Task)
}
