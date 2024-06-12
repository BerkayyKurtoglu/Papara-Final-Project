package com.berkaykurtoglu.recipequest.domain.repository

import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto.RecipeDetailDto
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow

interface DetailScreenRepository {

    suspend fun fetchRecipeFromNetwork(
        id : Int
    ) : Flow<ApiResult<RecipeDetailDto>>


    suspend fun saveRecipeToCache(
        recipe: RecipeDetailEntity
    )

    suspend fun getCacheCount() : Int

    suspend fun getOldestRecipe() : RecipeDetailEntity

    suspend fun deleteRecipeFromCache(id : Int) : Int

    suspend fun saveRecipeToFavorites(recipe: RecipeDetailEntity) : Long

    suspend fun deleteRecipeFromFavorites(id : Int) : Int

    suspend fun getRecipeByIdFromCache(id : Int) : Flow<ApiResult<RecipeDetailEntity?>>

    suspend fun getRecipeByIdFromFavorite(id : Int) : Flow<ApiResult<RecipeDetailEntity>>

}