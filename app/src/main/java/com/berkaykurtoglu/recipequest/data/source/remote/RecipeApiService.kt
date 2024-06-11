package com.berkaykurtoglu.recipequest.data.source.remote

import com.berkaykurtoglu.recipequest.data.source.remote.dto.allrecipesdto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.data.source.remote.dto.searchdto.RecipeSearchDto
import com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto.RecipeDetailDto
import com.berkaykurtoglu.recipequest.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApiService {

    @GET(Constants.COMPLEX_SEARCH)
    suspend fun getRecipes(
        @Query("apiKey") apiKey: String = Constants.API_KEY,
        @Query("addRecipeInformation") addRecipeInformation: Boolean = true,
        @Query("addRecipeNutrition") addRecipeNutrition: Boolean = true,
        @Query("offset") offset: Int = 0,
        @Query("number") number: Int = 50,
        @Query("sort") sort : String = "random"
    ) : RecipeResponseDto

    @GET(Constants.GET_RECIPE_DETAIL)
    suspend fun getRecipeById(
        @Path("id") id: Int,
        @Query("apiKey") apiKey: String = Constants.API_KEY,
        ) : RecipeDetailDto

    @GET(Constants.AUTO_COMPLETE)
    suspend fun searchRecipes(
        @Query("apiKey") apiKey: String = Constants.API_KEY,
        @Query("query") query: String,
        @Query("number") number: Int = 10,
    ) : RecipeSearchDto


}