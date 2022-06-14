package com.escodro.domain.provider

import java.util.Calendar

internal class CalendarProviderImpl : CalendarProvider {
    override fun getCurrentCalendar(): Calendar = Calendar.getInstance()
}
