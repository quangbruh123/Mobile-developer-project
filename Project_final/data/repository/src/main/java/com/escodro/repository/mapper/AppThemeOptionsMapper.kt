package com.escodro.repository.mapper

import com.escodro.domain.model.AppThemeOptions as DomainThemeOptions
import com.escodro.repository.model.AppThemeOptions as RepoThemeOptions

internal class AppThemeOptionsMapper {
    fun toDomain(appThemeOptions: RepoThemeOptions): DomainThemeOptions =
        when (appThemeOptions) {
            RepoThemeOptions.LIGHT -> DomainThemeOptions.LIGHT
            RepoThemeOptions.DARK -> DomainThemeOptions.DARK
            RepoThemeOptions.SYSTEM -> DomainThemeOptions.SYSTEM
        }

    fun toRepo(appThemeOptions: DomainThemeOptions): RepoThemeOptions =
        when (appThemeOptions) {
            DomainThemeOptions.LIGHT -> RepoThemeOptions.LIGHT
            DomainThemeOptions.DARK -> RepoThemeOptions.DARK
            DomainThemeOptions.SYSTEM -> RepoThemeOptions.SYSTEM
        }
}
