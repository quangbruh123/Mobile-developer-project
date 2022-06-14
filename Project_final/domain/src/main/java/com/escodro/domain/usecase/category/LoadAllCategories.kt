package com.escodro.domain.usecase.category

import com.escodro.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface LoadAllCategories {
    operator fun invoke(): Flow<List<Category>>
}
