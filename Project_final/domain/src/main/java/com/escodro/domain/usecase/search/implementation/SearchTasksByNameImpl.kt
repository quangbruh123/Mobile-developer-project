package com.escodro.domain.usecase.search.implementation

import com.escodro.domain.model.TaskWithCategory
import com.escodro.domain.repository.SearchRepository
import com.escodro.domain.usecase.search.SearchTasksByName
import kotlinx.coroutines.flow.Flow

internal class SearchTasksByNameImpl(
    private val searchRepository: SearchRepository
) : SearchTasksByName {
    override suspend operator fun invoke(query: String): Flow<List<TaskWithCategory>> =
        searchRepository.findTaskByName(query)
}
