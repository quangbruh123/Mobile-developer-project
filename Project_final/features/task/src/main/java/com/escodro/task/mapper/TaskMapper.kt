package com.escodro.task.mapper

import com.escodro.domain.model.Task as DomainTask
import com.escodro.task.model.Task as ViewTask

internal class TaskMapper(private val alarmIntervalMapper: AlarmIntervalMapper) {
    fun toView(domainTask: DomainTask): ViewTask =
        ViewTask(
            id = domainTask.id,
            completed = domainTask.completed,
            title = domainTask.title,
            description = domainTask.description,
            dueDate = domainTask.dueDate,
            categoryId = domainTask.categoryId,
            creationDate = domainTask.creationDate,
            completedDate = domainTask.completedDate,
            isRepeating = domainTask.isRepeating,
            alarmInterval = alarmIntervalMapper.toViewData(domainTask.alarmInterval)
        )
}
