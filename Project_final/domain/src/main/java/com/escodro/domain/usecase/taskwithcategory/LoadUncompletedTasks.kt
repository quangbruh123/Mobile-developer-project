package com.escodro.domain.usecase.taskwithcategory

import com.escodro.domain.model.TaskWithCategory
import kotlinx.coroutines.flow.Flow

interface LoadUncompletedTasks {
    operator fun invoke(categoryId: Long? = null): Flow<List<TaskWithCategory>>
}
