package com.berkaykurtoglu.recipequest.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity

@Database(
    entities = [
        RecipeDetailEntity::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    Converters::class
)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}