package com.berkaykurtoglu.recipequest.di

import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import com.berkaykurtoglu.recipequest.domain.repository.SplashScreenRepository
import com.berkaykurtoglu.recipequest.domain.usecase.CheckNetworkUseCase
import com.berkaykurtoglu.recipequest.domain.usecase.DeleteAllCacheUseCase
import com.berkaykurtoglu.recipequest.domain.usecase.GetAllRecipesFromLocalUseCase
import com.berkaykurtoglu.recipequest.domain.usecase.GetAllRecipesRandomlyUseCase
import com.berkaykurtoglu.recipequest.domain.usecase.InsertCacheUseCase
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

    @Singleton
    @Provides
    fun provideUseCase(
        checkNetworkUseCase: CheckNetworkUseCase,
        getAllRecipesRandomlyUseCase: GetAllRecipesRandomlyUseCase,
        getAllRecipesFromLocalUseCase: GetAllRecipesFromLocalUseCase,
        deleteAllCacheUseCase: DeleteAllCacheUseCase,
        insertCacheUseCase: InsertCacheUseCase
    ) = UseCase(
        checkNetworkUseCase = checkNetworkUseCase,
        getAllRecipesRandomlyUseCase = getAllRecipesRandomlyUseCase,
        getAllRecipesFromLocalUseCase = getAllRecipesFromLocalUseCase,
        deleteAllCacheUseCase = deleteAllCacheUseCase,
        insertCacheUseCase = insertCacheUseCase
    )


}