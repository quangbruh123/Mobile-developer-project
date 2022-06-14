package com.escodro.task.model

import com.escodro.categoryapi.model.Category

data class TaskWithCategory(
    val task: Task,
    val category: Category? = null
)
