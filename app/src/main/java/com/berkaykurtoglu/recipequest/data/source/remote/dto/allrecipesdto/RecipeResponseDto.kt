package com.berkaykurtoglu.recipequest.data.source.remote.dto.allrecipesdto


import com.berkaykurtoglu.recipequest.domain.model.recipesmodel.RecipeModel
import com.google.gson.annotations.SerializedName

data class RecipeResponseDto(
    @SerializedName("number")
    val number: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("totalResults")
    val totalResults: Int
){

    fun toRecipeModelList() : List<RecipeModel>
        = results.map {
            RecipeModel(
                sourceName = it.sourceName,
                title = it.title,
                image = it.image,
                readyInMinutes = it.readyInMinutes,
                id = it.id
            )
        }


}