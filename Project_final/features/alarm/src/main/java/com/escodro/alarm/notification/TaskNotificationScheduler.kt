package com.escodro.alarm.notification

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.escodro.alarm.TaskReceiver
import com.escodro.core.extension.cancelAlarm
import com.escodro.core.extension.setExactAlarm
import logcat.logcat

internal class TaskNotificationScheduler(private val context: Context) {
    fun scheduleTaskAlarm(taskId: Long, timeInMillis: Long) {
        val receiverIntent = Intent(context, TaskReceiver::class.java).apply {
            action = TaskReceiver.ALARM_ACTION
            putExtra(TaskReceiver.EXTRA_TASK, taskId)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            taskId.toInt(),
            receiverIntent,
            PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        logcat { "Scheduling notification for '$taskId' at '$timeInMillis'" }
        context.setExactAlarm(timeInMillis, pendingIntent)
    }

    fun cancelTaskAlarm(taskId: Long) {
        val receiverIntent = Intent(context, TaskReceiver::class.java)
        receiverIntent.action = TaskReceiver.ALARM_ACTION

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            taskId.toInt(),
            receiverIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        logcat { "Canceling notification with id '$taskId'" }
        context.cancelAlarm(pendingIntent)
    }
}
