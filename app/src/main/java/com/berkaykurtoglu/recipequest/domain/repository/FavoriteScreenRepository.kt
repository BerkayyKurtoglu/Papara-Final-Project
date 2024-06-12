package com.berkaykurtoglu.recipequest.domain.repository

import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.util.SourceResult
import kotlinx.coroutines.flow.Flow

interface FavoriteScreenRepository {


    suspend fun getAllFavoriteRecipes() : Flow<SourceResult<List<RecipeDetailEntity>>>


}