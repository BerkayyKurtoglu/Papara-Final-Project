package com.berkaykurtoglu.recipequest.data.source.remote.dto.similarrecipedto


import com.google.gson.annotations.SerializedName

data class RecipeSimilarDtoItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageType")
    val imageType: String,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int,
    @SerializedName("servings")
    val servings: Int,
    @SerializedName("sourceUrl")
    val sourceUrl: String,
    @SerializedName("title")
    val title: String
)