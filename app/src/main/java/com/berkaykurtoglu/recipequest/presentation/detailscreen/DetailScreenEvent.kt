package com.berkaykurtoglu.recipequest.presentation.detailscreen

import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.RecipeDetailModel

sealed class DetailScreenEvent {

    data object OnAddFavorite : DetailScreenEvent()
}