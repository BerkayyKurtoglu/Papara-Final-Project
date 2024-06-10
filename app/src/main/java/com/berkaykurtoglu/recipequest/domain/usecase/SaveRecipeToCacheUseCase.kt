package com.berkaykurtoglu.recipequest.domain.usecase

import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.domain.repository.DetailScreenRepository
import javax.inject.Inject

class SaveRecipeToCacheUseCase @Inject constructor (
    private val detailScreenRepository: DetailScreenRepository
) {

    suspend operator fun invoke(
        recipe: RecipeDetailEntity
    ) = detailScreenRepository.saveRecipeToCache(recipe)


}