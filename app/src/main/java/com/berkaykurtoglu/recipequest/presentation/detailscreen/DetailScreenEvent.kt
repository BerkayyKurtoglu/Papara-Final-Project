package com.berkaykurtoglu.recipequest.presentation.detailscreen

import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.RecipeDetailModel

sealed class DetailScreenEvent {

    data object OnAddFavorite : DetailScreenEvent()
    data class OnGetRecipeById(val id : Int?, val comingScreenId : Int?, val isNetworkAvailable : Boolean) : DetailScreenEvent()
}