package com.escodro.categoryapi.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow


abstract class CategoryListViewModel : ViewModel() {
    abstract fun loadCategories(): Flow<CategoryState>
}
