package com.escodro.task.model

@Suppress("MagicNumber")
enum class AlarmInterval(val index: Int?) {
    NEVER(0),
    HOURLY(1),
    DAILY(2),
    WEEKLY(3),
    MONTHLY(4),
    YEARLY(5)
}
