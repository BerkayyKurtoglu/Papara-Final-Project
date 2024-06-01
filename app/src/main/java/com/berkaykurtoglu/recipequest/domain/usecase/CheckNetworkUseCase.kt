package com.berkaykurtoglu.recipequest.domain.usecase

import com.berkaykurtoglu.recipequest.domain.repository.SplashScreenRepository
import javax.inject.Inject

class CheckNetworkUseCase @Inject constructor(
    private val splashScreenRepository: SplashScreenRepository
) {

        operator fun invoke() = splashScreenRepository.isNetworkAvailable()

}