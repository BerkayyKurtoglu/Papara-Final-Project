package com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto


import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.UsModel
import com.google.gson.annotations.SerializedName

data class Us(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("unitLong")
    val unitLong: String,
    @SerializedName("unitShort")
    val unitShort: String
){

    fun toUsModel() =
        UsModel(
            amount = amount,
            unitLong = unitLong,
            unitShort = unitShort
        )


}