package com.berkaykurtoglu.recipequest.data.source.local.favoritesdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.berkaykurtoglu.recipequest.data.source.local.Converters
import com.berkaykurtoglu.recipequest.data.source.local.entity.LocalRecipeResponse
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity

@Database(
    entities = [RecipeDetailEntity::class],
    version = 1,
)
@TypeConverters(
    Converters::class
)
abstract class FavoritesDatabase : RoomDatabase() {
    abstract fun favoritesDao() : FavoritesDao
}