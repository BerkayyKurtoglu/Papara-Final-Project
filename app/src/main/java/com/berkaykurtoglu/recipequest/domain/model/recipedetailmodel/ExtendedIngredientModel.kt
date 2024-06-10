package com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel


import com.google.gson.annotations.SerializedName

data class ExtendedIngredientModel(
    val aisle: String,
    val amount: Double,
    val consistency: String,
    val id: Int,
    val image: String,
    val measuresModel: MeasuresModel?,
    val meta: List<String>?,
    val name: String,
    val nameClean: String,
    val original: String,
    val originalName: String,
    val unit: String
)