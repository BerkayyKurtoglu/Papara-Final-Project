package com.berkaykurtoglu.recipequest.presentation.navigation

import androidx.navigation.NavController

class RecipeQuestNavAction(
    private val navController: NavController
) {

    fun navigateToRecipeDetail(){
        navController.navigate(Screens.DetailScreen.route)
    }

    fun navigateToHome(isNetworkAvailable : Boolean){
        navController.navigate(Screens.HomeScreen.route+"$isNetworkAvailable"){
            popUpTo(Screens.SplashScreen.route) {
                inclusive = true
                saveState = true
            }
        }
    }


}