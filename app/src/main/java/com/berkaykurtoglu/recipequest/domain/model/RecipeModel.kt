package com.berkaykurtoglu.recipequest.domain.model


import com.google.gson.annotations.SerializedName

data class RecipeModel(
    val number: Int? = null,
    val offset: Int? = null,
    var resultModels: List<ResultModel>? = null,
    val totalResults: Int? = null
)