package com.berkaykurtoglu.recipequest.data.source.local.entity

import androidx.room.Embedded
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.ExtendedIngredientModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.MeasuresModel

data class ExtendedIngredientEntity(
    val aisle: String,
    val amount: Double,
    val consistency: String,
    val id: Int,
    val image: String,
    val name: String,
    val nameClean: String,
    val original: String,
    val originalName: String,
    val unit: String
){

    fun toExtendedIngredientModel() =
        ExtendedIngredientModel(
            aisle,
            amount,
            consistency,
            id,
            image,
            measuresModel = null,
            meta = null,
            name,
            nameClean,
            original,
            originalName,
            unit)


}