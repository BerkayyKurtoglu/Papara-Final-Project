package com.berkaykurtoglu.recipequest.domain.datasource

import com.berkaykurtoglu.recipequest.data.source.remote.dto.allrecipesdto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.data.source.remote.dto.searchdto.RecipeSearchDto
import com.berkaykurtoglu.recipequest.data.source.remote.dto.similarrecipedto.RecipeSimilarDto
import com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto.RecipeDetailDto
import com.berkaykurtoglu.recipequest.util.SourceResult
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getRecipeById(
        id : Int
    ) : Flow<SourceResult<RecipeDetailDto>>

    suspend fun getRecipesRandomly(
        offset: Int,
        number: Int,
        mealType : String
    ) : RecipeResponseDto

    suspend fun searchRecipes(
        query : String
    ) : Flow<SourceResult<RecipeSearchDto>>

    suspend fun suggestSimilarRecipe(
        id : Int
    ) : RecipeSimilarDto

}