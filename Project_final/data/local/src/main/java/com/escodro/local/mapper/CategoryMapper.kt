package com.escodro.local.mapper

import com.escodro.local.model.Category as LocalCategory
import com.escodro.repository.model.Category as RepoCategory

internal class CategoryMapper {
    fun fromRepo(repoCategory: RepoCategory): LocalCategory =
        LocalCategory(
            id = repoCategory.id,
            name = repoCategory.name,
            color = repoCategory.color
        )

    fun fromRepo(repoCategoryList: List<RepoCategory>): List<LocalCategory> =
        repoCategoryList.map { fromRepo(it) }

    fun toRepo(localCategory: LocalCategory): RepoCategory =
        RepoCategory(
            id = localCategory.id,
            name = localCategory.name,
            color = localCategory.color
        )

    fun toRepo(localCategoryList: List<LocalCategory>): List<RepoCategory> =
        localCategoryList.map { toRepo(it) }
}
