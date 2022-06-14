package com.escodro.repository.mapper

import com.escodro.domain.model.TaskWithCategory as DomainTaskWithCategory
import com.escodro.repository.model.TaskWithCategory as RepoTaskWithCategory

internal class TaskWithCategoryMapper(
    private val taskMapper: TaskMapper,
    private val categoryMapper: CategoryMapper
) {

    fun toDomain(localTaskList: List<RepoTaskWithCategory>): List<DomainTaskWithCategory> =
        localTaskList.map { toDomain(it) }

    private fun toDomain(localTask: RepoTaskWithCategory): DomainTaskWithCategory =
        DomainTaskWithCategory(
            task = taskMapper.toDomain(localTask.task),
            category = localTask.category?.let { categoryMapper.toDomain(it) }
        )
}
