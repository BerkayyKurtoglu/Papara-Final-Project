package com.berkaykurtoglu.recipequest.presentation.navigation

import androidx.navigation.NavController

class RecipeQuestNavAction(
    private val navController: NavController
) {

    fun navigateToRecipeDetail(){
        navController.navigate(Screens.DetailScreen.route)
    }

    fun navigateToHome(){
        navController.navigate(Screens.HomeScreen.route)
    }


}