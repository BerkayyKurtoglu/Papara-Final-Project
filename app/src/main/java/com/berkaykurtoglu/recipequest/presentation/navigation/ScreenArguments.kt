package com.berkaykurtoglu.recipequest.presentation.navigation

import androidx.navigation.NavType

enum class ScreenArguments(
    val argument: String,
    val type : NavType<*>
){

    DetailScreenRecipeId("name", NavType.IntType),
    DetailScreenComingId("id", NavType.IntType)

}