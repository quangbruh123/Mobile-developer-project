package com.escodro.local.converter

import androidx.room.TypeConverter
import com.escodro.local.model.AlarmInterval

internal class AlarmIntervalConverter {
    @TypeConverter
    fun toAlarmInterval(id: Int?): AlarmInterval? =
        AlarmInterval.values().find { it.id == id }

    @TypeConverter
    fun toId(alarmInterval: AlarmInterval?): Int? =
        alarmInterval?.id
}
