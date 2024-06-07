package com.berkaykurtoglu.recipequest.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "local_recipes"
)
data class LocalRecipeResponse(
    @PrimaryKey
    val id: Int,
    val cookingMinutes: Int?,
    val dairyFree: Boolean,
    val glutenFree: Boolean,
    val healthScore: Int,
    val image: String,
    val imageType: String,
    val lowFodmap: Boolean,
    val preparationMinutes: Int?,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceName: String,
    val sourceUrl: String,
    val summary: String,
    val title: String,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
    val calorieAmount: Double,
    val calorieUnit: String,
    val fatAmount: Double,
    val fatUnit: String,
    val proteinAmount: Double,
    val proteinUnit: String,
    val carbohydrateAmount : Double,
    val carbohydrateUnit : String

)