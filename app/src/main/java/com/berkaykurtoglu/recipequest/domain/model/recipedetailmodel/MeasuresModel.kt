package com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel


import com.google.gson.annotations.SerializedName

data class MeasuresModel(
    val metricModel: MetricModel,
    val usModel: UsModel
)