package com.berkaykurtoglu.recipequest.domain.usecase

import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository

class DeleteAllCacheUseCase(
    private val homeRepository: HomeRepository
) {

    suspend operator fun invoke() = homeRepository.deleteAllCache()


}