package com.berkaykurtoglu.recipequest.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.berkaykurtoglu.recipequest.data.source.local.cachedatabase.CacheDao
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.data.source.remote.RecipesPagingSource
import com.berkaykurtoglu.recipequest.data.source.remote.dto.searchdto.RecipeSearchDto
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import com.berkaykurtoglu.recipequest.domain.model.recipesmodel.RecipeModel
import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import com.berkaykurtoglu.recipequest.util.SourceResult
import com.berkaykurtoglu.recipequest.util.apiFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor (
    private val remoteDataSource: RemoteDataSource,
    private val cacheDataSource: CacheDao
) : HomeRepository {

    override suspend fun getAllRecipesFromCache(): Flow<PagingData<RecipeModel>> =
        Pager(
            config = PagingConfig(pageSize = 10, prefetchDistance = 2),
            pagingSourceFactory = { cacheDataSource.cacheGetAllRecipes() }
        ).flow.map {pagingData->
            pagingData.map {
                it.toRecipeModel()
            }
        }

    override suspend fun getAllRecipesNetwork(
        type : String
    ): Flow<PagingData<RecipeModel>> =
        Pager(
            config = PagingConfig(pageSize = 10, prefetchDistance = 1),
            pagingSourceFactory = { RecipesPagingSource(type,remoteDataSource) }
        ).flow

    override suspend fun searchRecipesFromNetwork(query: String): Flow<SourceResult<RecipeSearchDto>> =
        remoteDataSource.searchRecipes(query)

    override suspend fun searchRecipesFromCache(query: String): Flow<SourceResult<List<RecipeDetailEntity>>> =
        apiFlow {
            cacheDataSource.cacheSearchRecipes(query)
        }

}