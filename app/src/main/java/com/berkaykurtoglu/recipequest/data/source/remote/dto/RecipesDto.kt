package com.berkaykurtoglu.recipequest.data.source.remote.dto


import com.google.gson.annotations.SerializedName

data class RecipesDto(
    @SerializedName("number")
    val number: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("totalResults")
    val totalResults: Int
)