package com.escodro.task.mapper

import com.escodro.task.model.AlarmInterval.DAILY
import com.escodro.task.model.AlarmInterval.HOURLY
import com.escodro.task.model.AlarmInterval.MONTHLY
import com.escodro.task.model.AlarmInterval.NEVER
import com.escodro.task.model.AlarmInterval.WEEKLY
import com.escodro.task.model.AlarmInterval.YEARLY
import com.escodro.domain.model.AlarmInterval as DomainInterval
import com.escodro.task.model.AlarmInterval as ViewDataInterval

internal class AlarmIntervalMapper {
    fun toDomain(alarmInterval: ViewDataInterval): DomainInterval? =
        when (alarmInterval) {
            HOURLY -> DomainInterval.HOURLY
            DAILY -> DomainInterval.DAILY
            WEEKLY -> DomainInterval.WEEKLY
            MONTHLY -> DomainInterval.MONTHLY
            YEARLY -> DomainInterval.YEARLY
            NEVER -> null
        }

    fun toViewData(alarmInterval: DomainInterval?): ViewDataInterval =
        when (alarmInterval) {
            DomainInterval.HOURLY -> HOURLY
            DomainInterval.DAILY -> DAILY
            DomainInterval.WEEKLY -> WEEKLY
            DomainInterval.MONTHLY -> MONTHLY
            DomainInterval.YEARLY -> YEARLY
            null -> NEVER
        }
}
