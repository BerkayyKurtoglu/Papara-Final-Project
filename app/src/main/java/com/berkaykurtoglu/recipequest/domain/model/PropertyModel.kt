package com.berkaykurtoglu.recipequest.domain.model


import com.google.gson.annotations.SerializedName

data class PropertyModel(
    val amount: Double,
    val name: String,
    val unit: String
)