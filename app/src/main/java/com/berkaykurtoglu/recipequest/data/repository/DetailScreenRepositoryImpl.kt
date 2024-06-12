package com.berkaykurtoglu.recipequest.data.repository

import com.berkaykurtoglu.recipequest.data.source.local.cachedatabase.CacheDao
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.data.source.local.favoritesdatabase.FavoritesDao
import com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto.RecipeDetailDto
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import com.berkaykurtoglu.recipequest.domain.repository.DetailScreenRepository
import com.berkaykurtoglu.recipequest.util.SourceResult
import com.berkaykurtoglu.recipequest.util.apiFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailScreenRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val cacheDataSource : CacheDao,
    private val favoritesDataSource : FavoritesDao
) : DetailScreenRepository {

    override suspend fun fetchRecipeFromNetwork(id: Int) : Flow<SourceResult<RecipeDetailDto>> =
        remoteDataSource.getRecipeById(id)

    override suspend fun saveRecipeToCache(recipe: RecipeDetailEntity) =
        cacheDataSource.insertRecipe(recipe)

    override suspend fun getCacheCount(): Int =
        cacheDataSource.cacheGetCount()

    override suspend fun getOldestRecipe(): RecipeDetailEntity =
        cacheDataSource.cacheGetOldestRecipe()

    override suspend fun deleteRecipeFromCache(id : Int): Int =
        cacheDataSource.cacheDeleteRecipeFromCache(id)

    override suspend fun saveRecipeToFavorites(recipe: RecipeDetailEntity): Long =
        favoritesDataSource.insertRecipeToFavorites(recipe)

    override suspend fun deleteRecipeFromFavorites(id: Int): Int =
        favoritesDataSource.deleteRecipeFromFavorites(id)

    override suspend fun getRecipeByIdFromCache(id: Int): Flow<SourceResult<RecipeDetailEntity?>> =
        apiFlow {
            cacheDataSource.cacheGetRecipeById(id)
        }

    override suspend fun getRecipeByIdFromFavorite(id: Int): Flow<SourceResult<RecipeDetailEntity>> =
        apiFlow {
            favoritesDataSource.getFavoriteById(id)
        }

}