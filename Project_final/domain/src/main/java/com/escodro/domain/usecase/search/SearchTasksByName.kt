package com.escodro.domain.usecase.search

import com.escodro.domain.model.TaskWithCategory
import kotlinx.coroutines.flow.Flow

interface SearchTasksByName {
    suspend operator fun invoke(query: String): Flow<List<TaskWithCategory>>
}
