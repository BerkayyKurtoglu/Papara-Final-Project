package com.berkaykurtoglu.recipequest.domain.usecase

import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.domain.model.recipesearchmodel.RecipeSearchModel
import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRecipeFromCacheUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

    suspend operator fun invoke(query : String) : Flow<ApiResult<List<RecipeDetailEntity>>> =
        homeRepository.searchRecipesFromCache(query)


}