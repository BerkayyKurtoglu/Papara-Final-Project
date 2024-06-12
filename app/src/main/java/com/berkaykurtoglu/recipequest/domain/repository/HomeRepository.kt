package com.berkaykurtoglu.recipequest.domain.repository

import androidx.paging.PagingData
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.data.source.remote.dto.searchdto.RecipeSearchDto
import com.berkaykurtoglu.recipequest.domain.model.recipesmodel.RecipeModel
import com.berkaykurtoglu.recipequest.util.SourceResult
import kotlinx.coroutines.flow.Flow

interface HomeRepository {


    suspend fun getAllRecipesFromCache() : Flow<PagingData<RecipeModel>>

    suspend fun getAllRecipesNetwork(
        type : String
    ) : Flow<PagingData<RecipeModel>>

    suspend fun searchRecipesFromNetwork(
        query : String
    ) : Flow<SourceResult<RecipeSearchDto>>

    suspend fun searchRecipesFromCache(
        query : String
    ) : Flow<SourceResult<List<RecipeDetailEntity>>>

}