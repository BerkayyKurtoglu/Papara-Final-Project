package com.berkaykurtoglu.recipequest.domain.model


data class NutrientXModel(
    val amount: Double,
    val name: String,
    val percentOfDailyNeeds: Double,
    val unit: String
)