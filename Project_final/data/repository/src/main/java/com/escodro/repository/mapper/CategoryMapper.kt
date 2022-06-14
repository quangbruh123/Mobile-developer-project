package com.escodro.repository.mapper

import com.escodro.domain.model.Category as DomainCategory
import com.escodro.repository.model.Category as RepoCategory

internal class CategoryMapper {
    fun toDomain(repoCategory: RepoCategory): DomainCategory =
        DomainCategory(
            id = repoCategory.id,
            name = repoCategory.name,
            color = repoCategory.color
        )

    fun toDomain(repoCategoryList: List<RepoCategory>): List<DomainCategory> =
        repoCategoryList.map { toDomain(it) }

    fun toRepo(localCategory: DomainCategory): RepoCategory =
        RepoCategory(
            id = localCategory.id,
            name = localCategory.name,
            color = localCategory.color
        )

    fun toRepo(localCategoryList: List<DomainCategory>): List<RepoCategory> =
        localCategoryList.map { toRepo(it) }
}
