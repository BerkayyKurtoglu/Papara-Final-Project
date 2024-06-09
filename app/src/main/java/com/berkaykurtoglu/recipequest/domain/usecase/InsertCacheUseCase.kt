package com.berkaykurtoglu.recipequest.domain.usecase

import com.berkaykurtoglu.recipequest.data.source.local.entity.LocalRecipeResponse
import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository

class InsertCacheUseCase(
    private val homeRepository: HomeRepository
) {

    suspend operator fun invoke(
        list : List<LocalRecipeResponse>
    ) = homeRepository.updateCache(list)


}