package com.escodro.domain.usecase.taskwithcategory

import com.escodro.domain.model.TaskWithCategory
import com.escodro.domain.repository.TaskWithCategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LoadCompletedTasks(private val repository: TaskWithCategoryRepository) {
    operator fun invoke(): Flow<List<TaskWithCategory>> =
        repository.findAllTasksWithCategory()
            .map { list -> list.filter { item -> item.task.completed } }
}
