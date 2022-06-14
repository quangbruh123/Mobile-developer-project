@file:JvmName("extension-context")

package com.escodro.core.extension

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.annotation.ColorRes
import androidx.core.app.AlarmManagerCompat
import androidx.core.net.toUri
import logcat.LogPriority
import logcat.asLog
import logcat.logcat
import java.util.Calendar

private const val InvalidVersion = "x.x.x"

fun Context.setExactAlarm(
    triggerAtMillis: Long,
    operation: PendingIntent?,
    type: Int = AlarmManager.RTC_WAKEUP
) {
    val currentTime = Calendar.getInstance().timeInMillis
    if (triggerAtMillis <= currentTime) {
        logcat(LogPriority.WARN) { "It is not possible to set alarm in the past" }
        return
    }

    if (operation == null) {
        logcat(LogPriority.ERROR) { "PendingIntent is null" }
        return
    }

    val manager = getAlarmManager()
    manager?.let {
        AlarmManagerCompat
            .setExactAndAllowWhileIdle(it, type, triggerAtMillis, operation)
    }
}

fun Context.cancelAlarm(operation: PendingIntent?) {
    if (operation == null) {
        logcat(LogPriority.ERROR) { "PendingIntent is null" }
        return
    }

    val manager = getAlarmManager()
    manager?.let { manager.cancel(operation) }
}

@SuppressLint("ResourceType")
fun Context.getStringColor(@ColorRes colorRes: Int): String =
    resources.getString(colorRes)

fun Context.openUrl(url: String) {
    with(Intent(Intent.ACTION_VIEW)) {
        this.data = url.toUri()
        startActivity(this)
    }
}

fun Context.getVersionName(): String {
    var packageInfo: PackageInfo? = null
    packageName.let {
        try {
            packageInfo = packageManager.getPackageInfo(it, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            logcat(LogPriority.ERROR) { e.asLog() }
        }
    }
    return packageInfo?.versionName ?: InvalidVersion
}
