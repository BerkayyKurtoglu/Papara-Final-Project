package com.berkaykurtoglu.recipequest.data.repository

import com.berkaykurtoglu.recipequest.data.source.remote.dto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor (
    private val remoteDataSource: RemoteDataSource
) : HomeRepository {

    override fun getRecipesRandomly() : Flow<ApiResult<RecipeResponseDto>> {
        return remoteDataSource.getRecipeRandomly()
    }

}