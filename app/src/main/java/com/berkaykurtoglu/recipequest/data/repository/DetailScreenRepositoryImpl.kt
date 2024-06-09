package com.berkaykurtoglu.recipequest.data.repository

import com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto.RecipeDetailDto
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import com.berkaykurtoglu.recipequest.domain.repository.DetailScreenRepository
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailScreenRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : DetailScreenRepository {

    override suspend fun fetchRecipeFromNetwork(id: Int) : Flow<ApiResult<RecipeDetailDto>> =
        remoteDataSource.getRecipeById(id)


}