package com.berkaykurtoglu.recipequest.presentation.homescreen

import com.berkaykurtoglu.recipequest.data.source.remote.dto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.domain.model.RecipeModel
import com.berkaykurtoglu.recipequest.util.FilterCategorie

data class HomeScreenState(

    val isLoading : Boolean = false,
    val errorMessage : String = "",
    val recipes : RecipeModel = RecipeModel(),
    val chipIndex : FilterCategorie = FilterCategorie.All

)