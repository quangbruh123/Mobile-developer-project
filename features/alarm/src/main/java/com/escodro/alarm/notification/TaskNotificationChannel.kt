package com.escodro.alarm.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.escodro.alarm.R
import com.escodro.core.extension.getNotificationManager

internal class TaskNotificationChannel(context: Context) {

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = context.getString(R.string.channel_task_name)
            val description = context.getString(R.string.channel_task_description)
            val importance = NotificationManager.IMPORTANCE_HIGH

            NotificationChannel(CHANNEL_ID, name, importance).apply {
                this.description = description
                context.getNotificationManager()?.createNotificationChannel(this)
            }
        }
    }

    fun getChannelId() = CHANNEL_ID

    companion object {

        const val CHANNEL_ID = "task_notification_channel"
    }
}
