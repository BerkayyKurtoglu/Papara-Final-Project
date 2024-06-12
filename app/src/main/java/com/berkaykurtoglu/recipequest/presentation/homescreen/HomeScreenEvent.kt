package com.berkaykurtoglu.recipequest.presentation.homescreen

import com.berkaykurtoglu.recipequest.util.FilterCategorie

sealed class HomeScreenEvent {

    data class OnFetchRecipes(val isConnected : Boolean) : HomeScreenEvent()
    data class OnFilter(val filter : FilterCategorie) : HomeScreenEvent()
    data class OnSearchRecipes(val query : String) : HomeScreenEvent()
    data object RefreshThePage : HomeScreenEvent()

}