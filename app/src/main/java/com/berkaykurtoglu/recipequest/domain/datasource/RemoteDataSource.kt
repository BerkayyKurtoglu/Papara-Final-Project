package com.berkaykurtoglu.recipequest.domain.datasource

import com.berkaykurtoglu.recipequest.data.source.remote.dto.allrecipesdto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto.RecipeDetailDto
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getRecipesRandomly(
        offset : Int,
        number : Int
    ) : Flow<ApiResult<RecipeResponseDto>>

    fun getRecipeById(
        id : Int
    ) : Flow<ApiResult<RecipeDetailDto>>

}