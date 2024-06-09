package com.berkaykurtoglu.recipequest.domain.model.recipesmodel


import com.google.gson.annotations.SerializedName

data class WeightPerServingModel(
    val amount: Int,
    val unit: String
)