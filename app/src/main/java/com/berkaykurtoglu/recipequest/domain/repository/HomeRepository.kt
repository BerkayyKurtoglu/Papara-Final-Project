package com.berkaykurtoglu.recipequest.domain.repository

import com.berkaykurtoglu.recipequest.data.source.local.entity.LocalRecipeResponse
import com.berkaykurtoglu.recipequest.data.source.remote.dto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getAllRecipesFromNetwork() : Flow<ApiResult<RecipeResponseDto>>

    suspend fun getAllRecipesFromLocal() : Flow<List<LocalRecipeResponse>>

}