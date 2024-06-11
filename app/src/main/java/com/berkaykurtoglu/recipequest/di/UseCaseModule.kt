package com.berkaykurtoglu.recipequest.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

   /* @Singleton
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
    ) = SaveRecipeToCacheUseCase(detailScreenRepository)

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

    @Provides
    @Singleton
    fun provideInsertFavoritesUseCase(
        detailScreenRepository: DetailScreenRepository
    ) = InsertRecipeToFavoriteUseCase(detailScreenRepository)

    /*@Singleton
    @Provides
    fun provideUseCase(
        checkNetworkUseCase: CheckNetworkUseCase,
        getAllRecipesRandomlyUseCase: GetAllRecipesRandomlyUseCase,
        getAllRecipesFromLocalUseCase: GetAllRecipesFromLocalUseCase,
        deleteAllCacheUseCase: DeleteAllCacheUseCase,
        insertCacheUseCase: InsertCacheUseCase,
        getRecipeByIdFromNetworkUseCase: GetRecipeByIdFromNetworkUseCase,
        saveRecipeToCacheUseCase: SaveRecipeToCacheUseCase,
        getCacheCountUseCase: GetCacheCountUseCase,
        getOldestRecipeUseCase: GetOldestRecipeUseCase,
        deleteRecipeFromCache: DeleteRecipeCacheUseCase,
        insertRecipeToFavoriteUseCase: InsertRecipeToFavoriteUseCase
    ) = UseCase(
        checkNetworkUseCase = checkNetworkUseCase,
        getAllRecipesRandomlyUseCase = getAllRecipesRandomlyUseCase,
        getAllRecipesFromLocalUseCase = getAllRecipesFromLocalUseCase,
        deleteAllCacheUseCase = deleteAllCacheUseCase,
        insertCacheUseCase = insertCacheUseCase,
        getRecipeByIdFromNetworkUseCase = getRecipeByIdFromNetworkUseCase,
        saveRecipeToCacheUseCase = saveRecipeToCacheUseCase,
        getCacheCountUseCase = getCacheCountUseCase,
        getOldestUseCase = getOldestRecipeUseCase,
        deleteRecipeFromCache = deleteRecipeFromCache,
        insertRecipeToFavoriteUseCase = insertRecipeToFavoriteUseCase
    )*/*/


}