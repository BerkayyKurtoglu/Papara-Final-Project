package com.berkaykurtoglu.recipequest.domain.model.recipesmodel

data class RecipeModel(
    val sourceName : String,
    val title : String,
    val readyInMinutes : Int,
    val image : String,
    val id : Int
)