package com.escodro.domain.usecase.tracker

import com.escodro.domain.model.TaskWithCategory
import kotlinx.coroutines.flow.Flow

interface LoadCompletedTasksByPeriod {
    operator fun invoke(): Flow<List<TaskWithCategory>>
}
