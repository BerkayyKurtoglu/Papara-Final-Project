package com.berkaykurtoglu.recipequest.presentation.navigation


sealed class Screens(val route: String) {

    data object DetailScreen : Screens("detail")
    data object HomeScreen : Screens("home")
    data object SplashScreen : Screens("splash")

}

