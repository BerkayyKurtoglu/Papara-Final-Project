package com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel


import com.google.gson.annotations.SerializedName

data class IngredientModel(
    val id: Int,
    val image: String,
    val localizedName: String,
    val name: String
)