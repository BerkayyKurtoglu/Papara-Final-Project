package com.berkaykurtoglu.recipequest.presentation.navigation


sealed class Screens(val route: String, val id : Int) {

    data object DetailScreen : Screens("detail",0)
    data object HomeScreen : Screens("home",1)
    data object SplashScreen : Screens("splash",4)
    data object FavoriteScreen : Screens("favorite",2)

}

