package com.berkaykurtoglu.recipequest.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.berkaykurtoglu.recipequest.data.source.local.entity.LocalRecipeResponse

@Database(
    entities = [
        LocalRecipeResponse::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}