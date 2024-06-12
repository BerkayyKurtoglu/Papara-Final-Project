package com.berkaykurtoglu.recipequest.presentation.homescreen

import com.berkaykurtoglu.recipequest.domain.model.recipesearchmodel.RecipeSearchModel
import com.berkaykurtoglu.recipequest.domain.model.recipesmodel.RecipeModel
import com.berkaykurtoglu.recipequest.util.FilterCategorie

data class HomeScreenState(

    val recipes : List<RecipeModel> = listOf(),
    val chipIndex : FilterCategorie = FilterCategorie.Random,

    val searchIsLoading : Boolean = false,
    val searchErrorMessage : String = "",
    val searchRecipesResult : List<RecipeSearchModel> = listOf(),

    val isNetworkConnected : Boolean = false

)