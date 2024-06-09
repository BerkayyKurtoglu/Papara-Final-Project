package com.berkaykurtoglu.recipequest.domain.model.recipesmodel


data class NutritionModel(
    val ingredientModels: List<IngredientModel>,//Avocado, Carrot
    val nutrients: List<NutrientXModel>,//Calories, Protein
)