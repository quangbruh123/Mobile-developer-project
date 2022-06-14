package com.escodro.datastore.mapper

import com.escodro.datastore.model.AppThemeOptions as DataStoreThemeOptions
import com.escodro.repository.model.AppThemeOptions as RepoThemeOptions

internal class AppThemeOptionsMapper {
    fun toDataStore(appThemeOptions: RepoThemeOptions): DataStoreThemeOptions =
        when (appThemeOptions) {
            RepoThemeOptions.LIGHT -> DataStoreThemeOptions.LIGHT
            RepoThemeOptions.DARK -> DataStoreThemeOptions.DARK
            RepoThemeOptions.SYSTEM -> DataStoreThemeOptions.SYSTEM
        }

    fun toRepo(appThemeOptions: DataStoreThemeOptions): RepoThemeOptions =
        when (appThemeOptions) {
            DataStoreThemeOptions.LIGHT -> RepoThemeOptions.LIGHT
            DataStoreThemeOptions.DARK -> RepoThemeOptions.DARK
            DataStoreThemeOptions.SYSTEM -> RepoThemeOptions.SYSTEM
        }
}
