package com.escodro.domain.usecase.preferences

import com.escodro.domain.model.AppThemeOptions
import kotlinx.coroutines.flow.Flow

class LoadAppTheme(private val preferencesRepository: PreferencesRepository) {
    operator fun invoke(): Flow<AppThemeOptions> =
        preferencesRepository.loadAppTheme()
}
