package com.berkaykurtoglu.recipequest.data.source.remote

import com.berkaykurtoglu.recipequest.data.source.remote.dto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import com.berkaykurtoglu.recipequest.util.ApiResult
import com.berkaykurtoglu.recipequest.util.apiFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: RecipeApiService
) : RemoteDataSource {

    override fun getRecipeRandomly(): Flow<ApiResult<RecipeResponseDto>> =
        apiFlow <RecipeResponseDto> {
            apiService.getRecipes()
        }

}