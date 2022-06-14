package com.escodro.task.mapper

import com.escodro.domain.model.TaskWithCategory as DomainTaskWithCategory
import com.escodro.task.model.TaskWithCategory as ViewTaskWithCategory

internal class TaskWithCategoryMapper(
    private val taskMapper: TaskMapper,
    private val categoryMapper: CategoryMapper
) {
    fun toView(localTaskList: List<DomainTaskWithCategory>): List<ViewTaskWithCategory> =
        localTaskList.map { toView(it) }

    private fun toView(localTask: DomainTaskWithCategory): ViewTaskWithCategory =
        ViewTaskWithCategory(
            task = taskMapper.toView(localTask.task),
            category = localTask.category?.let { categoryMapper.toView(it) }
        )
}
