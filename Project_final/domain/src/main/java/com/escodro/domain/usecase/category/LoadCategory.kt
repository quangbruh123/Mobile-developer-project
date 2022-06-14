package com.escodro.domain.usecase.category

import com.escodro.domain.model.Category
import com.escodro.domain.repository.CategoryRepository

class LoadCategory(private val categoryRepository: CategoryRepository) {
    suspend operator fun invoke(categoryId: Long): Category? =
        categoryRepository.findCategoryById(categoryId)
}
