package com.berkaykurtoglu.recipequest.domain.repository

import com.berkaykurtoglu.recipequest.data.source.local.entity.LocalRecipeResponse
import com.berkaykurtoglu.recipequest.data.source.remote.dto.allrecipesdto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getAllRecipesFromNetwork(
        offset : Int,
        number : Int
    ) : Flow<ApiResult<RecipeResponseDto>>

    suspend fun getAllRecipesFromLocal() : Flow<List<LocalRecipeResponse>>

    suspend fun updateCache(
        localRecipeResponse : List<LocalRecipeResponse>
    )

    suspend fun deleteAllCache() : Int

}