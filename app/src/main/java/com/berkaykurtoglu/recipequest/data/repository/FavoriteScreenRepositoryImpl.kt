package com.berkaykurtoglu.recipequest.data.repository

import com.berkaykurtoglu.recipequest.data.source.local.entity.LocalRecipeResponse
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.data.source.local.favoritesdatabase.FavoritesDao
import com.berkaykurtoglu.recipequest.domain.repository.FavoriteScreenRepository
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FavoriteScreenRepositoryImpl @Inject constructor(
    private val favoriteDataSource : FavoritesDao
) : FavoriteScreenRepository {


    override suspend fun getAllFavoriteRecipes(): Flow<ApiResult<List<RecipeDetailEntity>>> =
        flow {
            emit(ApiResult.Loading)
            try {
                emit(ApiResult.Success(favoriteDataSource.getFavorites()))
            }catch (e : Exception){
                emit(ApiResult.Error(e.localizedMessage ?:" Unexpected Error"))
            }
        }


}