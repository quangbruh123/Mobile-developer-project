package com.escodro.domain.repository

import com.escodro.domain.model.TaskWithCategory
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun findTaskByName(query: String): Flow<List<TaskWithCategory>>
}
