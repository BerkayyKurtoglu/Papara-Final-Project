package com.berkaykurtoglu.recipequest.data.source.local.entity

import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.EquipmentModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.IngredientModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.StepModel

data class StepEntity(
    val ingredientModels: List<IngredientEntity>,
    val number: Int,
    val step: String
){

    fun toStepModel() =
        StepModel(
            ingredientModels = ingredientModels.map { it.toIngredientModel() },
            number = number,
            step = step,
            equipmentModels = null
        )

}