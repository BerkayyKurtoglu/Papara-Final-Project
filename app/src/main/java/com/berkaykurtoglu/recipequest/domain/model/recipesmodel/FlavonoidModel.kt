package com.berkaykurtoglu.recipequest.domain.model.recipesmodel


import com.google.gson.annotations.SerializedName

data class FlavonoidModel(
    val amount: Double,
    val name: String,
    val unit: String
)