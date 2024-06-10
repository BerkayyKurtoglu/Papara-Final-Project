package com.berkaykurtoglu.recipequest.data.source.local.entity

import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.AnalyzedInstructionModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.StepModel

data class AnalyzedInstructionEntity(
    val name: String,
    val stepModels: List<StepEntity>
){

    fun toAnalyzedInstructionModel(): AnalyzedInstructionModel =
        AnalyzedInstructionModel(
            name = name,
            stepModels = stepModels.map { it.toStepModel() }
        )



}