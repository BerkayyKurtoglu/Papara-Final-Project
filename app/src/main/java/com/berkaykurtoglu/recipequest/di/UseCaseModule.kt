package com.berkaykurtoglu.recipequest.di

import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import com.berkaykurtoglu.recipequest.domain.repository.DetailScreenRepository
import com.berkaykurtoglu.recipequest.domain.repository.SplashScreenRepository
import com.berkaykurtoglu.recipequest.domain.usecase.CheckNetworkUseCase
import com.berkaykurtoglu.recipequest.domain.usecase.DeleteAllCacheUseCase
import com.berkaykurtoglu.recipequest.domain.usecase.DeleteRecipeCacheUseCase
import com.berkaykurtoglu.recipequest.domain.usecase.GetAllRecipesFromLocalUseCase
import com.berkaykurtoglu.recipequest.domain.usecase.GetAllRecipesRandomlyUseCase
import com.berkaykurtoglu.recipequest.domain.usecase.GetCacheCountUseCase
import com.berkaykurtoglu.recipequest.domain.usecase.GetOldestRecipeUseCase
import com.berkaykurtoglu.recipequest.domain.usecase.GetRecipeByIdFromNetworkUseCase
import com.berkaykurtoglu.recipequest.domain.usecase.InsertCacheUseCase
import com.berkaykurtoglu.recipequest.domain.usecase.SaveRecipeToCache
import com.berkaykurtoglu.recipequest.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideNetworkUseCase(
        splashScreenRepository: SplashScreenRepository
    ) = CheckNetworkUseCase(splashScreenRepository)

    @Singleton
    @Provides
    fun provideGetAllRecipesNetworkUseCase(
        homeRepository: HomeRepository
    ) = GetAllRecipesRandomlyUseCase(homeRepository)

    @Singleton
    @Provides
    fun provideGetAllRecipesLocal(
        homeRepository: HomeRepository
    ) = GetAllRecipesFromLocalUseCase(homeRepository)

    @Singleton
    @Provides
    fun provideDeleteAllCacheUseCase(
        homeRepository: HomeRepository
    ) = DeleteAllCacheUseCase(homeRepository)

    @Provides
    @Singleton
    fun provideInsertCacheUseCase(
        homeRepository: HomeRepository
    ) = InsertCacheUseCase(homeRepository)

    @Provides
    @Singleton
    fun provideGetRecipeByIdUseCase(
        detailScreenRepository: DetailScreenRepository
    ) = GetRecipeByIdFromNetworkUseCase(detailScreenRepository)

    @Provides
    @Singleton
    fun provideSaveRecipeToCacheUseCase(
        detailScreenRepository: DetailScreenRepository
    ) = SaveRecipeToCache(detailScreenRepository)

    @Provides
    @Singleton
    fun provideGetCacheCountUseCase(
        detailScreenRepository: DetailScreenRepository
    ) = GetCacheCountUseCase(detailScreenRepository)

    @Provides
    @Singleton
    fun provideOldestUseCase(
        detailScreenRepository: DetailScreenRepository
    ) = GetOldestRecipeUseCase(detailScreenRepository)

    @Provides
    @Singleton
    fun provideDeleteRecipeCacheUseCase(
        detailScreenRepository: DetailScreenRepository
    ) = DeleteRecipeCacheUseCase(detailScreenRepository)

    @Singleton
    @Provides
    fun provideUseCase(
        checkNetworkUseCase: CheckNetworkUseCase,
        getAllRecipesRandomlyUseCase: GetAllRecipesRandomlyUseCase,
        getAllRecipesFromLocalUseCase: GetAllRecipesFromLocalUseCase,
        deleteAllCacheUseCase: DeleteAllCacheUseCase,
        insertCacheUseCase: InsertCacheUseCase,
        getRecipeByIdFromNetworkUseCase: GetRecipeByIdFromNetworkUseCase,
        saveRecipeToCache: SaveRecipeToCache,
        getCacheCountUseCase: GetCacheCountUseCase,
        getOldestRecipeUseCase: GetOldestRecipeUseCase,
        deleteRecipeFromCache: DeleteRecipeCacheUseCase
    ) = UseCase(
        checkNetworkUseCase = checkNetworkUseCase,
        getAllRecipesRandomlyUseCase = getAllRecipesRandomlyUseCase,
        getAllRecipesFromLocalUseCase = getAllRecipesFromLocalUseCase,
        deleteAllCacheUseCase = deleteAllCacheUseCase,
        insertCacheUseCase = insertCacheUseCase,
        getRecipeByIdFromNetworkUseCase = getRecipeByIdFromNetworkUseCase,
        saveRecipeToCache = saveRecipeToCache,
        getCacheCountUseCase = getCacheCountUseCase,
        getOldestUseCase = getOldestRecipeUseCase,
        deleteRecipeFromCache = deleteRecipeFromCache
    )


}