package com.escodro.domain.usecase.alarm

interface CancelAlarm {
    suspend operator fun invoke(taskId: Long)
}
