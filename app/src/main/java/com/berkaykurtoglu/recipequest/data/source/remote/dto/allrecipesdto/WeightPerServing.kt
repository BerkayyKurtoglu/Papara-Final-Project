package com.berkaykurtoglu.recipequest.data.source.remote.dto.allrecipesdto


import com.google.gson.annotations.SerializedName

data class WeightPerServing(
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("unit")
    val unit: String
)