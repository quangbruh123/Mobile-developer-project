package com.escodro.navigation

import android.net.Uri
import androidx.core.net.toUri

object Destinations {
    const val Home = "home"
    const val TaskDetail = "task_detail"
    const val About = "about"
    const val Tracker = "tracker"
}

object DestinationArgs {
    const val TaskId = "task_id"
}

object DestinationDeepLink {

    private val BaseUri = "app://com.escodro.alkaa".toUri()
    val HomePattern = "$BaseUri/home"
    val TaskDetailPattern = "$BaseUri/${DestinationArgs.TaskId}={${DestinationArgs.TaskId}}"

    fun getTaskDetailUri(taskId: Long): Uri =
        "$BaseUri/${DestinationArgs.TaskId}=$taskId".toUri()

    fun getTaskHomeUri(): Uri =
        HomePattern.toUri()
}
