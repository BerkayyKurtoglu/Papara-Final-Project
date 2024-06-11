package com.berkaykurtoglu.recipequest.data.source.local.cachedatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.berkaykurtoglu.recipequest.data.source.local.Converters
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity

@Database(
    entities = [
        RecipeDetailEntity::class,
    ],
    version = 1,
)
@TypeConverters(
    Converters::class
)
abstract class CacheDatabase : RoomDatabase() {
    abstract fun cacheDao(): CacheDao
}