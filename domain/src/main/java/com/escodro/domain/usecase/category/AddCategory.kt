package com.escodro.domain.usecase.category

import com.escodro.domain.model.Category

interface AddCategory {
    suspend operator fun invoke(category: Category)
}
