package com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel

import com.google.gson.annotations.SerializedName

data class StepModel(
    val equipmentModels: List<EquipmentModel>?,
    val ingredientModels: List<IngredientModel>,
    val number: Int,
    val step: String
)