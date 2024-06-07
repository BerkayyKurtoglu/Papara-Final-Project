package com.berkaykurtoglu.recipequest.domain.model


data class NutritionModel(
    val ingredientModels: List<IngredientModel>,//Avocado, Carrot
    val nutrients: List<NutrientXModel>,//Calories, Protein
)