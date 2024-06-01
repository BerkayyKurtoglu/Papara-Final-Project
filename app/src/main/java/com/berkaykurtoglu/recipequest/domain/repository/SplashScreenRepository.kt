package com.berkaykurtoglu.recipequest.domain.repository

import kotlinx.coroutines.flow.Flow

interface SplashScreenRepository {

    fun isNetworkAvailable(): Flow<Boolean>

}