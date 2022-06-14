package com.escodro.domain.usecase.preferences

import com.escodro.domain.model.AppThemeOptions

class UpdateAppTheme(private val preferencesRepository: PreferencesRepository) {
    suspend operator fun invoke(theme: AppThemeOptions) =
        preferencesRepository.updateAppTheme(theme)
}
