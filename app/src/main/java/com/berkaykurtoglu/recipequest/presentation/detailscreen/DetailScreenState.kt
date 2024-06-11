package com.berkaykurtoglu.recipequest.presentation.detailscreen

import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.RecipeDetailModel

data class DetailScreenState(
    val isLoading : Boolean = true,
    val errorMessage : String = "",
    val data : RecipeDetailModel? = null,
    val isFavorite : Boolean = false
)