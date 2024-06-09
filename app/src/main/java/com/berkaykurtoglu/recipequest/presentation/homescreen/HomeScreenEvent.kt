package com.berkaykurtoglu.recipequest.presentation.homescreen

import com.berkaykurtoglu.recipequest.util.FilterCategorie

sealed class HomeScreenEvent {

    data class OnFetchRecipes(val isConnected : Boolean, val offset : Int) : HomeScreenEvent()
    data class OnFilter(val filter : FilterCategorie) : HomeScreenEvent()

}