package com.berkaykurtoglu.recipequest.domain.repository

import com.berkaykurtoglu.recipequest.data.source.remote.dto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow

interface HomeRepository {


    fun getRecipesRandomly() : Flow<ApiResult<RecipeResponseDto>>


}