package com.escodro.glance.interactor

import com.escodro.domain.interactor.GlanceInteractor
import com.escodro.glance.presentation.TaskListGlanceWidget

internal class GlanceInteractorImpl : GlanceInteractor {
    override suspend fun onTaskListUpdated() {
        TaskListGlanceWidget().loadData()
    }
}
