package com.berkaykurtoglu.recipequest.di

import android.content.Context
import androidx.room.Room
import com.berkaykurtoglu.recipequest.data.source.local.RecipeDao
import com.berkaykurtoglu.recipequest.data.source.local.RecipeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): RecipeDatabase = Room.databaseBuilder(
        context,
        RecipeDatabase::class.java,
        "recipe_database"
    ).build()

    @Singleton
    @Provides
    fun provideRecipeDao(
        database: RecipeDatabase
    ) : RecipeDao = database.recipeDao()


}