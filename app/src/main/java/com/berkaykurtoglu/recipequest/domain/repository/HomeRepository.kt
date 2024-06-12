package com.berkaykurtoglu.recipequest.domain.repository

import androidx.paging.PagingData
import com.berkaykurtoglu.recipequest.data.source.local.entity.LocalRecipeResponse
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.data.source.remote.dto.allrecipesdto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.data.source.remote.dto.searchdto.RecipeSearchDto
import com.berkaykurtoglu.recipequest.domain.model.recipesearchmodel.RecipeSearchModel
import com.berkaykurtoglu.recipequest.domain.model.recipesmodel.RecipeModel
import com.berkaykurtoglu.recipequest.util.ApiResult
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getAllRecipesFromNetwork(
        offset : Int,
        number : Int
    ) : Flow<ApiResult<RecipeResponseDto>>

    suspend fun getAllRecipesFromCache() : Flow<PagingData<RecipeModel>>

    suspend fun getAllRecipesNetwork(
        type : String
    ) : Flow<PagingData<RecipeModel>>

    suspend fun searchRecipesFromNetwork(
        query : String
    ) : Flow<ApiResult<RecipeSearchDto>>

    suspend fun searchRecipesFromCache(
        query : String
    ) : Flow<ApiResult<List<RecipeDetailEntity>>>

}