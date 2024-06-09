package com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto


import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.MeasuresModel
import com.google.gson.annotations.SerializedName

data class Measures(
    @SerializedName("metric")
    val metric: Metric,
    @SerializedName("us")
    val us: Us
){

    fun toMeasuresModel() =
        MeasuresModel(
            metricModel = metric.toMetricModel(),
            usModel = us.toUsModel()
        )


}