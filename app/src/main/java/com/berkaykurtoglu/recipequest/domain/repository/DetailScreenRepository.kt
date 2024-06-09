package com.berkaykurtoglu.recipequest.domain.repository

import com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto.RecipeDetailDto
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow

interface DetailScreenRepository {

    suspend fun fetchRecipeFromNetwork(
        id : Int
    ) : Flow<ApiResult<RecipeDetailDto>>



}