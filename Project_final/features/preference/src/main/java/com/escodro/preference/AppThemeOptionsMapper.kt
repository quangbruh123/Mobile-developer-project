package com.escodro.preference

import com.escodro.domain.model.AppThemeOptions as DomainThemeOptions
import com.escodro.preference.model.AppThemeOptions as ViewDataThemeOptions

internal class AppThemeOptionsMapper {
    fun toViewData(appThemeOptions: DomainThemeOptions): ViewDataThemeOptions =
        when (appThemeOptions) {
            DomainThemeOptions.LIGHT -> ViewDataThemeOptions.LIGHT
            DomainThemeOptions.DARK -> ViewDataThemeOptions.DARK
            DomainThemeOptions.SYSTEM -> ViewDataThemeOptions.SYSTEM
        }

    fun toDomain(appThemeOptions: ViewDataThemeOptions): DomainThemeOptions =
        when (appThemeOptions) {
            ViewDataThemeOptions.LIGHT -> DomainThemeOptions.LIGHT
            ViewDataThemeOptions.DARK -> DomainThemeOptions.DARK
            ViewDataThemeOptions.SYSTEM -> DomainThemeOptions.SYSTEM
        }
}