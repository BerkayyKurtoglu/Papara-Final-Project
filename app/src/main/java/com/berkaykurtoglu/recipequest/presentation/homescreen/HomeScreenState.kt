package com.berkaykurtoglu.recipequest.presentation.homescreen

import com.berkaykurtoglu.recipequest.data.source.remote.dto.RecipeResponseDto

data class HomeScreenState(

    val isLoading : Boolean = false,
    val errorMessage : String = "",
    val recipes : List<RecipeResponseDto> = emptyList()

)