package com.berkaykurtoglu.recipequest.data.repository

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.berkaykurtoglu.recipequest.domain.repository.SplashScreenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


class SplashScreenRepositoryImpl @Inject constructor (
    private val connectivityManager: ConnectivityManager
) : SplashScreenRepository {


    override fun isNetworkAvailable(): Flow<Boolean> = flow {
        emit(checkNetworkAvailability())
    }

    private fun checkNetworkAvailability(): Boolean {
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }


}