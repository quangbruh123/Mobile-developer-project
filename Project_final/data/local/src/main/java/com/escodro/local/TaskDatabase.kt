package com.escodro.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.escodro.local.converter.AlarmIntervalConverter
import com.escodro.local.converter.DateConverter
import com.escodro.local.dao.CategoryDao
import com.escodro.local.dao.TaskDao
import com.escodro.local.dao.TaskWithCategoryDao
import com.escodro.local.model.Category
import com.escodro.local.model.Task

@Database(entities = [Task::class, Category::class], version = 4)
@TypeConverters(DateConverter::class, AlarmIntervalConverter::class)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun taskWithCategoryDao(): TaskWithCategoryDao
    abstract fun categoryDao(): CategoryDao
}
