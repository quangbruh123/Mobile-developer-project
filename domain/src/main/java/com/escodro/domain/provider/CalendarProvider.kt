package com.escodro.domain.provider

import java.util.Calendar

interface CalendarProvider {
    fun getCurrentCalendar(): Calendar
}
