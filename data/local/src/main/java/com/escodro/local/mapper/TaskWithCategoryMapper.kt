package com.escodro.local.mapper

import com.escodro.local.model.TaskWithCategory as LocalTaskWithCategory
import com.escodro.repository.model.TaskWithCategory as RepoTaskWithCategory

internal class TaskWithCategoryMapper(
    private val taskMapper: TaskMapper,
    private val categoryMapper: CategoryMapper
) {

    fun toRepo(localTaskList: List<LocalTaskWithCategory>): List<RepoTaskWithCategory> =
        localTaskList.map { toRepo(it) }

    private fun toRepo(localTask: LocalTaskWithCategory): RepoTaskWithCategory =
        RepoTaskWithCategory(
            task = taskMapper.toRepo(localTask.task),
            category = localTask.category?.let { categoryMapper.toRepo(it) }
        )
}
