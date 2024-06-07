package com.berkaykurtoglu.recipequest.domain.model


import com.google.gson.annotations.SerializedName

data class CaloricBreakdownModel(
    val percentCarbs: Double,
    val percentFat: Double,
    val percentProtein: Double
)