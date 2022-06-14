package com.escodro.local.model

import androidx.room.Embedded
import androidx.room.Entity

data class TaskWithCategory(
    @Embedded val task: Task,
    @Embedded val category: Category? = null
)
