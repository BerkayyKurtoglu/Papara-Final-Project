package com.berkaykurtoglu.recipequest.domain.model


data class IngredientModel(
    val amount: Double,
    val id: Int,
    val name: String,
    val nutrients: List<NutrientXModel>,
    val unit: String
)