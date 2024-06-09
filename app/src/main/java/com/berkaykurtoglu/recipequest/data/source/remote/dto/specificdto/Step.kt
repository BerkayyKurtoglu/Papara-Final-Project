package com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto


import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.StepModel
import com.google.gson.annotations.SerializedName

data class Step(
    @SerializedName("equipment")
    val equipment: List<Equipment>,
    @SerializedName("ingredients")
    val ingredients: List<Ingredient>,
    @SerializedName("number")
    val number: Int,
    @SerializedName("step")
    val step: String
){

    fun toStepModel() =
        StepModel(
            equipmentModels = equipment.map { it.toEquipmentModel() },
            ingredientModels = ingredients.map { it.toIngredientModel() },
            number = number,
            step = step
        )

}