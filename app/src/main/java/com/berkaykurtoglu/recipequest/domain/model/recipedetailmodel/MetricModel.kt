package com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel


import com.google.gson.annotations.SerializedName

data class MetricModel(
    val amount: Double,
    val unitLong: String,
    val unitShort: String
)