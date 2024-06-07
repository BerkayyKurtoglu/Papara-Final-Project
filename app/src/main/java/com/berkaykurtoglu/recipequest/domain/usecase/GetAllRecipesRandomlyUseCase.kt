package com.berkaykurtoglu.recipequest.domain.usecase

import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import javax.inject.Inject

class GetAllRecipesRandomlyUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

    suspend operator fun invoke() = homeRepository.getAllRecipesFromNetwork()

}