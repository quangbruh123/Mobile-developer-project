package com.escodro.search.presentation

import com.escodro.search.model.TaskSearchItem

internal sealed class SearchViewState {
    internal object Loading : SearchViewState()
    internal data class Loaded(val taskList: List<TaskSearchItem>) : SearchViewState()
    internal object Empty : SearchViewState()
}
