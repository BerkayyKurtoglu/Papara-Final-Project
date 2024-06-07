package com.berkaykurtoglu.recipequest.presentation.homescreen

sealed class HomeScreenEvent {

    data class OnFirstCall(val isConnected : Boolean) : HomeScreenEvent()

}