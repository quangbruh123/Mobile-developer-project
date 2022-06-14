package com.escodro.preference.di

import com.escodro.preference.AppThemeOptionsMapper
import com.escodro.preference.presentation.PreferenceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val preferenceModule = module {

    viewModel { PreferenceViewModel(get(), get(), get()) }

    factory { AppThemeOptionsMapper() }
}
