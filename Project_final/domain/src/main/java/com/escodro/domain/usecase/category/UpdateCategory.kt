package com.escodro.domain.usecase.category

import com.escodro.domain.model.Category

interface UpdateCategory {
    suspend operator fun invoke(category: Category)
}
