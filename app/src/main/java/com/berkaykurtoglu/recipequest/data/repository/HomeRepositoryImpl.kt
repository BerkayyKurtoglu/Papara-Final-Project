package com.berkaykurtoglu.recipequest.data.repository

import com.berkaykurtoglu.recipequest.data.mapextension.toLocal
import com.berkaykurtoglu.recipequest.data.source.local.RecipeDao
import com.berkaykurtoglu.recipequest.data.source.local.entity.LocalRecipeResponse
import com.berkaykurtoglu.recipequest.data.source.remote.dto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: RecipeDao
) : HomeRepository {

    override suspend fun getAllRecipesFromNetwork() : Flow<ApiResult<RecipeResponseDto>> {
        val response = remoteDataSource.getRecipeRandomly()
        response.collect{
            when(it) {
                is ApiResult.Success -> {
                    deleteAllDatabase()
                    updateLocalDatabase(it.data.toLocal())
                }
                else ->{}
            }
        }
        return response
    }

    override suspend fun getAllRecipesFromLocal(): Flow<List<LocalRecipeResponse>>
        =localDataSource.getAllRecipes()

    private suspend fun updateLocalDatabase(
        localRecipeResponse : List<LocalRecipeResponse>
    ){
        localDataSource.insertAllRecipes(localRecipeResponse)
    }

    private suspend fun deleteAllDatabase(){
        localDataSource.deleteAllRecipes()
    }


}