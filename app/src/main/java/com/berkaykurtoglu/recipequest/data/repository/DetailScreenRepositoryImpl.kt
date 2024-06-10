package com.berkaykurtoglu.recipequest.data.repository

import com.berkaykurtoglu.recipequest.data.source.local.RecipeDao
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto.RecipeDetailDto
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import com.berkaykurtoglu.recipequest.domain.repository.DetailScreenRepository
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailScreenRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource : RecipeDao
) : DetailScreenRepository {

    override suspend fun fetchRecipeFromNetwork(id: Int) : Flow<ApiResult<RecipeDetailDto>> =
        remoteDataSource.getRecipeById(id)

    override suspend fun saveRecipeToCache(recipe: RecipeDetailEntity) =
        localDataSource.insertRecipe(recipe)

    override suspend fun getCacheCount(): Int =
        localDataSource.getCacheCount()

    override suspend fun getOldestRecipe(): RecipeDetailEntity =
        localDataSource.getOldestRecipe()

    override suspend fun deleteRecipeFromCache(id : Int): Int =
        localDataSource.deleteRecipeFromCache(id)


}