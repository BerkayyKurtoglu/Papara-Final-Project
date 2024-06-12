package com.berkaykurtoglu.recipequest.domain.usecase

import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import com.berkaykurtoglu.recipequest.util.SourceResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRecipeFromCacheUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

    suspend operator fun invoke(query : String) : Flow<SourceResult<List<RecipeDetailEntity>>> =
        homeRepository.searchRecipesFromCache(query)


}