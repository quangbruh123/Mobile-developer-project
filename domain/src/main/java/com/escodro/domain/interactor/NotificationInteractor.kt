package com.escodro.domain.interactor

import com.escodro.domain.model.Task

interface NotificationInteractor {
    fun show(task: Task)
    fun dismiss(notificationId: Long)
}
