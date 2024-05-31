package com.berkaykurtoglu.recipequest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.berkaykurtoglu.recipequest.presentation.detaiscreen.RecipeDetailScreen
import com.berkaykurtoglu.recipequest.presentation.homescreen.HomeScreen
import com.berkaykurtoglu.recipequest.presentation.splashscreen.SplashScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun RecipeQuestNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String = Screens.SplashScreen.route,
    navAction: RecipeQuestNavAction = remember(navController) {
        RecipeQuestNavAction(navController)
    }
) {

    val currentNavBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentNavBackStack?.destination?.route ?: startDestination

    NavHost(
        modifier = modifier,
        startDestination = startDestination,
        navController = navController
    ){

        composable(
            route = Screens.SplashScreen.route
        ){
            SplashScreen() {
                navAction.navigateToHome()
            }
        }

        composable(
            route = Screens.HomeScreen.route
        ){
            HomeScreen(
                coroutineScope = coroutineScope
            ) {
                navAction.navigateToRecipeDetail()
            }
        }

        composable(
            route = Screens.DetailScreen.route
        ){
            RecipeDetailScreen(
                coroutineScope = coroutineScope
            )
        }



    }



}