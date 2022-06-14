package com.escodro.alarm.mapper

import com.escodro.alarm.model.Task as ViewTask
import com.escodro.domain.model.Task as DomainTask

internal class TaskMapper {
    fun fromDomain(domainTask: DomainTask): ViewTask =
        ViewTask(
            id = domainTask.id,
            title = domainTask.title,
            dueDate = domainTask.dueDate,
            isCompleted = domainTask.completed
        )
}
