package com.berkaykurtoglu.recipequest.di

import android.content.Context
import androidx.room.Room
import com.berkaykurtoglu.recipequest.data.source.local.cachedatabase.CacheDao
import com.berkaykurtoglu.recipequest.data.source.local.cachedatabase.CacheDatabase
import com.berkaykurtoglu.recipequest.data.source.local.favoritesdatabase.FavoritesDao
import com.berkaykurtoglu.recipequest.data.source.local.favoritesdatabase.FavoritesDatabase
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
    fun provideCacheDatabase(
        @ApplicationContext context: Context
    ): CacheDatabase = Room.databaseBuilder(
        context,
        CacheDatabase::class.java,
        "cache_database"
    ).build()

    @Singleton
    @Provides
    fun provideRecipeDao(
        database: CacheDatabase
    ) : CacheDao = database.cacheDao()

    @Singleton
    @Provides
    fun provideFavoriteDatabase(
        @ApplicationContext context: Context
    ): FavoritesDatabase = Room.databaseBuilder(
        context,
        FavoritesDatabase::class.java,
        "favorites_database"
    ).build()

    @Singleton
    @Provides
    fun provideFavoritesDao(
        database: FavoritesDatabase
    ) : FavoritesDao = database.favoritesDao()


}