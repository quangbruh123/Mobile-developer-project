package com.escodro.domain.interactor

interface AlarmInteractor {
    fun schedule(alarmId: Long, timeInMillis: Long)
    fun cancel(alarmId: Long)
}
