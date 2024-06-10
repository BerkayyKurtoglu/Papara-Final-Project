package com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel


data class RecipeDetailModel(
    val analyzedInstructionModels: List<AnalyzedInstructionModel>,
    val allergenList: List<AllergenModel>,
    val dishTypes: List<String>,
    val extendedIngredientModels: List<ExtendedIngredientModel>,
    val id: Int,
    val image: String,
    val instructions: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceName: String,
    val sourceUrl: String,
    val spoonacularScore: Double,
    val summary: String,
    val title: String,
    val veryPopular: Boolean,
)