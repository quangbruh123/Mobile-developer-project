package com.escodro.domain.usecase.alarm

import com.escodro.domain.model.AlarmInterval

interface UpdateTaskAsRepeating {
    suspend operator fun invoke(taskId: Long, interval: AlarmInterval?)
}
