package com.escodro.categoryapi.presentation

import com.escodro.categoryapi.model.Category

sealed class CategoryState {
    object Loading : CategoryState()
    data class Loaded(val categoryList: List<Category>) : CategoryState()
    object Empty : CategoryState()
}
