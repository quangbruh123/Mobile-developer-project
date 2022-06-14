package com.escodro.search.di

import com.escodro.search.mapper.TaskSearchMapper
import com.escodro.search.presentation.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {

    // Presentation
    viewModel { SearchViewModel(get(), get()) }

    // Mappers
    factory { TaskSearchMapper() }
}
