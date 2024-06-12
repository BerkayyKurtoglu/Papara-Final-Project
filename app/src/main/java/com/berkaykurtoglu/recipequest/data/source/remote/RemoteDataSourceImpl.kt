package com.berkaykurtoglu.recipequest.data.source.remote

import com.berkaykurtoglu.recipequest.data.source.remote.dto.allrecipesdto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.data.source.remote.dto.searchdto.RecipeSearchDto
import com.berkaykurtoglu.recipequest.data.source.remote.dto.similarrecipedto.RecipeSimilarDto
import com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto.RecipeDetailDto
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import com.berkaykurtoglu.recipequest.util.ApiResult
import com.berkaykurtoglu.recipequest.util.apiFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: RecipeApiService
) : RemoteDataSource {

    override fun getRecipeById(id: Int): Flow<ApiResult<RecipeDetailDto>> =
        apiFlow {
            apiService.getRecipeById(id)
        }

    override suspend fun getRecipesRandomly(
        offset: Int,
        number: Int,
        mealType: String
    ): RecipeResponseDto =
        apiService.getRecipes(
            offset = offset,
            number = number,
            type = mealType
        )

    override suspend fun searchRecipes(query: String): Flow<ApiResult<RecipeSearchDto>> =
        apiFlow {
            apiService.searchRecipes(query = query)
        }

    override suspend fun suggestSimilarRecipe(id: Int): RecipeSimilarDto =
        apiService.getSimilarRecipe(id = id)

}