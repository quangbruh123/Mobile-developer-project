package com.escodro.domain.usecase.alarm

import java.util.Calendar

interface ScheduleAlarm {
    suspend operator fun invoke(taskId: Long, calendar: Calendar)
}
