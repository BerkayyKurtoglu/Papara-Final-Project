package com.berkaykurtoglu.recipequest.domain.usecase

import com.berkaykurtoglu.recipequest.domain.repository.DetailScreenRepository
import javax.inject.Inject

class GetOldestRecipeUseCase @Inject constructor(
    private val detailScreenRepository: DetailScreenRepository
) {

    suspend operator fun invoke() = detailScreenRepository.getOldestRecipe()

}