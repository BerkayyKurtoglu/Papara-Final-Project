package com.berkaykurtoglu.recipequest.data.source.remote.dto.searchdto


import com.google.gson.annotations.SerializedName

data class RecipeSearchDtoItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageType")
    val imageType: String,
    @SerializedName("title")
    val title: String
)