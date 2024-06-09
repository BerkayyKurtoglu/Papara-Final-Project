package com.berkaykurtoglu.recipequest.domain.usecase

import com.berkaykurtoglu.recipequest.domain.repository.DetailScreenRepository
import javax.inject.Inject

class GetRecipeByIdFromNetworkUseCase @Inject constructor(
    private val detailScreenRepository: DetailScreenRepository
) {

    suspend operator fun invoke(
        id : Int
    ) = detailScreenRepository.fetchRecipeFromNetwork(id)

}