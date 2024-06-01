package com.berkaykurtoglu.recipequest.presentation.navigation

import androidx.navigation.NavType

sealed class Screens(val route: String) {

    data object DetailScreen : Screens("login")
    data object HomeScreen : Screens("home/")
    data object SplashScreen : Screens("splash")

}

enum class ScreenArguments(
    val argument: String,
    val type : NavType<*>
){

    HOME_SCREEN_ARGUMENT("isNetworkAvailable", NavType.BoolType)

}

