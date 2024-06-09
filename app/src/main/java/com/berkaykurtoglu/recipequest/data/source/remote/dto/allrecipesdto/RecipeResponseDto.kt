package com.berkaykurtoglu.recipequest.data.source.remote.dto.allrecipesdto


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
)