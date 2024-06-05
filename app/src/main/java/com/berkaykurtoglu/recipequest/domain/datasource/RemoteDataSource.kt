package com.berkaykurtoglu.recipequest.domain.datasource

import com.berkaykurtoglu.recipequest.data.source.remote.dto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getRecipeRandomly() : Flow<ApiResult<RecipeResponseDto>>

}