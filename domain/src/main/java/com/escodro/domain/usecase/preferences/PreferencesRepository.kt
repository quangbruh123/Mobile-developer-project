package com.escodro.domain.usecase.preferences

import com.escodro.domain.model.AppThemeOptions
import kotlinx.coroutines.flow.Flow

interface PreferencesRepository {
    suspend fun updateAppTheme(theme: AppThemeOptions)
    fun loadAppTheme(): Flow<AppThemeOptions>
}
