package com.berkaykurtoglu.recipequest.util

sealed class FilterCategorie(val category: String) {

    data object Random : FilterCategorie("Random")
    data object BreakFast : FilterCategorie("Breakfast")
    data object Lunch : FilterCategorie("Lunch")
    data object Dinner : FilterCategorie("Dinner")
    data object Vegetarian : FilterCategorie("Vegetarian")
    data object DairyFree : FilterCategorie("Dairy Free")
    data object GlutenFree : FilterCategorie("Gluten Free")


}