package com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel


import com.google.gson.annotations.SerializedName

data class AnalyzedInstructionModel(
    val name: String,
    val stepModels: List<StepModel>
)