package com.berkaykurtoglu.recipequest.data.repository

import com.berkaykurtoglu.recipequest.data.mapextension.toLocal
import com.berkaykurtoglu.recipequest.data.source.local.RecipeDao
import com.berkaykurtoglu.recipequest.data.source.local.entity.LocalRecipeResponse
import com.berkaykurtoglu.recipequest.data.source.remote.dto.allrecipesdto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.wait
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: RecipeDao
) : HomeRepository {


    override suspend fun getAllRecipesFromNetwork(
        offset : Int,
        number : Int
    ) : Flow<ApiResult<RecipeResponseDto>> = remoteDataSource.getRecipeRandomly(offset, number)

    override suspend fun getAllRecipesFromLocal(): Flow<List<LocalRecipeResponse>>
        =localDataSource.getAllRecipes()

    override suspend fun updateCache(
        localRecipeResponse : List<LocalRecipeResponse>
    ) = localDataSource.insertAllRecipes(localRecipeResponse)

    override suspend fun deleteAllCache() : Int=
        localDataSource.deleteAllRecipes()


}