package com.berkaykurtoglu.recipequest.domain.model.recipesmodel


data class RecipeModel(
    val number: Int? = null,
    val offset: Int? = null,
    var resultModels: List<ResultModel>? = null,
    val totalResults: Int? = null
)