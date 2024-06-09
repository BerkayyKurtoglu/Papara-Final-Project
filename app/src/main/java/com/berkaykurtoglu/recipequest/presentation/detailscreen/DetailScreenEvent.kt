package com.berkaykurtoglu.recipequest.presentation.detailscreen

import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.RecipeDetailModel

sealed class DetailScreenEvent {

    data class OnAddFavorite(val recipe : RecipeDetailModel) : DetailScreenEvent()
    data class OnGetRecipeById(val id : Int?) : DetailScreenEvent()

}