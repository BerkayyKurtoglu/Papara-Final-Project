package com.berkaykurtoglu.recipequest.data.source.local.entity

import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.AllergenModel

data class AllergenEntity(
    val name : String,
    val contains : Boolean
){

    fun toAllergenModel() =
        AllergenModel(
            name = name,
            contains = contains
        )



}