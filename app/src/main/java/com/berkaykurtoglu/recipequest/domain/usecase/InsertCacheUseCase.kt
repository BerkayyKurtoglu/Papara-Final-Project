package com.berkaykurtoglu.recipequest.domain.usecase

import com.berkaykurtoglu.recipequest.data.source.local.entity.LocalRecipeResponse
import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import javax.inject.Inject

class InsertCacheUseCase @Inject constructor (
    private val homeRepository: HomeRepository
) {

    suspend operator fun invoke(
        list : List<LocalRecipeResponse>
    ) = homeRepository.updateCache(list)


}