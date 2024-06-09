package com.berkaykurtoglu.recipequest.data.source.remote.dto.specificdto


import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.AnalyzedInstructionModel
import com.google.gson.annotations.SerializedName

data class AnalyzedInstruction(
    @SerializedName("name")
    val name: String,
    @SerializedName("steps")
    val steps: List<Step>
){

    fun toAnalyzedInstructionModel() =
        AnalyzedInstructionModel(
            name = name,
            stepModels = steps.map { it.toStepModel() }
        )


}