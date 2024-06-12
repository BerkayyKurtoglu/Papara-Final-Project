package com.berkaykurtoglu.recipequest.util

sealed class FilterCategorie(val category: String) {

    data object Random : FilterCategorie("Random")
    data object BreakFast : FilterCategorie("Breakfast")
    data object MainCourse : FilterCategorie("Main Course")
    data object SideDish : FilterCategorie("Side Dish")
    data object Dessert : FilterCategorie("Dessert")
    data object Drink : FilterCategorie("Drink")
    data object Snack : FilterCategorie("Snack")



}