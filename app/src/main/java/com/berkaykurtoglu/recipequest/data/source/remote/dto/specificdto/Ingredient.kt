package com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto


import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.IngredientModel
import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("localizedName")
    val localizedName: String,
    @SerializedName("name")
    val name: String
){

    fun toIngredientModel()=
        IngredientModel(
            id = id,
            image = image,
            localizedName = localizedName,
            name = name
        )


}