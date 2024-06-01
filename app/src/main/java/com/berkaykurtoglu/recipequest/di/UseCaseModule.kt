package com.berkaykurtoglu.recipequest.di

import com.berkaykurtoglu.recipequest.domain.repository.SplashScreenRepository
import com.berkaykurtoglu.recipequest.domain.usecase.CheckNetworkUseCase
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

}