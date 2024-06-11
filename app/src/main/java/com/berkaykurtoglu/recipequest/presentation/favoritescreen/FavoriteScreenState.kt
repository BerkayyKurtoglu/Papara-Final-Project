package com.berkaykurtoglu.recipequest.presentation.favoritescreen

import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.RecipeDetailModel

data class FavoriteScreenState(

    val isLoading: Boolean = true,
    val errorMessage : String = "",
    val favorites : List<RecipeDetailModel> = emptyList()

)