package com.berkaykurtoglu.recipequest.di

import android.net.ConnectivityManager
import com.berkaykurtoglu.recipequest.data.repository.DetailScreenRepositoryImpl
import com.berkaykurtoglu.recipequest.data.repository.FavoriteScreenRepositoryImpl
import com.berkaykurtoglu.recipequest.data.repository.HomeRepositoryImpl
import com.berkaykurtoglu.recipequest.data.repository.SplashScreenRepositoryImpl
import com.berkaykurtoglu.recipequest.data.source.local.cachedatabase.CacheDao
import com.berkaykurtoglu.recipequest.data.source.local.favoritesdatabase.FavoritesDao
import com.berkaykurtoglu.recipequest.data.source.remote.RecipeApiService
import com.berkaykurtoglu.recipequest.data.source.remote.RemoteDataSourceImpl
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import com.berkaykurtoglu.recipequest.domain.repository.DetailScreenRepository
import com.berkaykurtoglu.recipequest.domain.repository.FavoriteScreenRepository
import com.berkaykurtoglu.recipequest.domain.repository.SplashScreenRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule{

    @Singleton
    @Provides
    fun provideSplashRepository(
        connectivityManager: ConnectivityManager
    ) : SplashScreenRepository = SplashScreenRepositoryImpl(connectivityManager)

    @Singleton
    @Provides
    fun provideHomeRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: CacheDao
    ) : HomeRepository = HomeRepositoryImpl(remoteDataSource,localDataSource)

    @Singleton
    @Provides
    fun provideDetailRepository(
        remoteDataSource: RemoteDataSource,
        cacheDataSource: CacheDao,
        favoritesDataSource : FavoritesDao
        ) : DetailScreenRepository = DetailScreenRepositoryImpl(remoteDataSource,cacheDataSource,favoritesDataSource)

    @Singleton
    @Provides
    fun provideRemoteDataSource(
        apiService: RecipeApiService
    ) : RemoteDataSource = RemoteDataSourceImpl(apiService)

    @Singleton
    @Provides
    fun provideFavoritesRepository(
        favoritesDataSource : FavoritesDao
    ) : FavoriteScreenRepository = FavoriteScreenRepositoryImpl(favoritesDataSource)


}

