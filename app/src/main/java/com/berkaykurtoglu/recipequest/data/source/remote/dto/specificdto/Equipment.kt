package com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto


import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.EquipmentModel
import com.google.gson.annotations.SerializedName

data class Equipment(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("localizedName")
    val localizedName: String,
    @SerializedName("name")
    val name: String
){

    fun toEquipmentModel() =
        EquipmentModel(
            id = id,
            image = image,
            localizedName = localizedName,
            name = name
        )


}