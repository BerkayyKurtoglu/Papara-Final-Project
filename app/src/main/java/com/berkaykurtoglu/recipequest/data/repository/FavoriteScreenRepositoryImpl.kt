package com.berkaykurtoglu.recipequest.data.repository

import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.data.source.local.favoritesdatabase.FavoritesDao
import com.berkaykurtoglu.recipequest.domain.repository.FavoriteScreenRepository
import com.berkaykurtoglu.recipequest.util.SourceResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FavoriteScreenRepositoryImpl @Inject constructor(
    private val favoriteDataSource : FavoritesDao
) : FavoriteScreenRepository {


    override suspend fun getAllFavoriteRecipes(): Flow<SourceResult<List<RecipeDetailEntity>>> =
        flow {
            emit(SourceResult.Loading)
            try {
                emit(SourceResult.Success(favoriteDataSource.getFavorites()))
            }catch (e : Exception){
                emit(SourceResult.Error(e.localizedMessage ?:" Unexpected Error"))
            }
        }


}