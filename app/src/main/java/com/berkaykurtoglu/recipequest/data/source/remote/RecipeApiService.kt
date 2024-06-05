package com.berkaykurtoglu.recipequest.data.source.remote

import com.berkaykurtoglu.recipequest.data.source.remote.dto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.util.Contants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApiService {

    @GET(Contants.COMPLEX_SEARCH)
    suspend fun getRecipes(
        @Query("apiKey") apiKey: String = Contants.API_KEY,
        @Query("addRecipeInformation") addRecipeInformation: Boolean = true,
        @Query("instructionsRequired") instructionsRequired: Boolean = true,
        @Query("offset") offset: Int = 0,
        @Query("number") number: Int = 50
    ) : Response<RecipeResponseDto>

}