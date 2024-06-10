package com.berkaykurtoglu.recipequest.data.source.local.entity

import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.IngredientModel

data class IngredientEntity(
    val id: Int,
    val image: String,
    val localizedName: String,
    val name: String
){
    fun toIngredientModel() =
        IngredientModel(
            id = id,
            image = image,
            localizedName = localizedName,
            name = name
        )


}