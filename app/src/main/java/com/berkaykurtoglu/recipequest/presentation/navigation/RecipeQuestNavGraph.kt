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
import androidx.navigation.navArgument
import com.berkaykurtoglu.recipequest.presentation.detailscreen.RecipeDetailScreen
import com.berkaykurtoglu.recipequest.presentation.favoritescreen.FavoritesScreen
import com.berkaykurtoglu.recipequest.presentation.homescreen.HomeScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun RecipeQuestNavGraph(
    modifier: Modifier = Modifier,
    isNetworkAvailable: Boolean,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String = Screens.HomeScreen.route,
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
            route = Screens.HomeScreen.route,
        ){
            HomeScreen(
                coroutineScope = coroutineScope,
                isNetworkAvailable = isNetworkAvailable,
                onNavigateToDetail = {id->
                    navAction.navigateToRecipeDetail(id)
                },
                onNavigateToFavorite = {
                    navAction.navigateToFavorites()
                }
            )
        }

        composable(
            route = Screens.DetailScreen.route+"/{${ScreenArguments.DetailScreenRecipeId.argument}}",
            arguments = listOf(
                navArgument(ScreenArguments.DetailScreenRecipeId.argument){
                    type = ScreenArguments.DetailScreenRecipeId.type
                }
            )
        ){
            val recipeId = it.arguments?.getInt(ScreenArguments.DetailScreenRecipeId.argument)
            RecipeDetailScreen(
                coroutineScope = coroutineScope,
                isNetworkAvailable = isNetworkAvailable,
                recipeId = recipeId
            ){
                navController.navigateUp()
            }
        }

        composable(Screens.FavoriteScreen.route){
            FavoritesScreen()
        }


    }



}