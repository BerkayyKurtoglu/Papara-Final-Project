package com.berkaykurtoglu.recipequest.presentation.splashscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkaykurtoglu.recipequest.domain.usecase.CheckNetworkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val useCase: CheckNetworkUseCase
) : ViewModel() {

    private val screenState_ = MutableStateFlow(SplashScreenState())
    val screenState = screenState_.asStateFlow()

    fun checkNetworkAvailability(){
        viewModelScope.launch {
            delay(1000)
            useCase().collect{
                screenState_.value = screenState.value.copy(isLoading = false,connectionPassed = it)
                /*
                * screenState_.update{
                *   it.copy(isLoading = false,connectionPassed = it)
                * }*/
            }
        }
    }

}