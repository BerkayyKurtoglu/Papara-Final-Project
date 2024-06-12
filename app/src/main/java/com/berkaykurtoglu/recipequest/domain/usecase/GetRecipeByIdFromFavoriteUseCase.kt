package com.berkaykurtoglu.recipequest.domain.usecase

import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.domain.repository.DetailScreenRepository
import com.berkaykurtoglu.recipequest.util.SourceResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipeByIdFromFavoriteUseCase @Inject constructor(
    private val detailScreenRepository: DetailScreenRepository
) {

    suspend operator fun invoke(id : Int) : Flow<SourceResult<RecipeDetailEntity>> =
        detailScreenRepository.getRecipeByIdFromFavorite(id)


}