package com.escodro.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.escodro.local.model.TaskWithCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskWithCategoryDao {

    @Query(
        """SELECT * FROM task
            LEFT JOIN category ON task_category_id = category_id"""
    )
    fun findAllTasksWithCategory(): Flow<List<TaskWithCategory>>

    @Query(
        """SELECT * FROM task
            LEFT JOIN category ON task_category_id = category_id
            WHERE task_category_id = :categoryId"""
    )
    fun findAllTasksWithCategoryId(categoryId: Long): Flow<List<TaskWithCategory>>

    @Query(
        """SELECT * FROM task
            LEFT JOIN category ON task_category_id = category_id
            WHERE task_title LIKE :query
            ORDER BY task_is_completed
        """
    )
    fun findTaskByName(query: String): Flow<List<TaskWithCategory>>
}
