package com.berkaykurtoglu.recipequest.presentation.navigation

import androidx.navigation.NavType

enum class ScreenArguments(
    val argument: String,
    val type : NavType<*>
){

    HOME_SCREEN_ARGUMENT("isNetworkAvailable", NavType.BoolType)

}