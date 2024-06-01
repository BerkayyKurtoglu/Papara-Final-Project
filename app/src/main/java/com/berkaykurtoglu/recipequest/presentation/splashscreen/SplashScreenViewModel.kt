package com.berkaykurtoglu.recipequest.presentation.splashscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkaykurtoglu.recipequest.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow(SplashScreenState())
    val screenState = _screenState.asStateFlow()

    fun checkNetworkAvailability(){
        viewModelScope.launch {
            delay(1000)
            useCase.checkNetworkUseCase().collect{
                _screenState.value = screenState.value.copy(isLoading = false,connectionPassed = it)
                /*
                * screenState_.update{
                *   it.copy(isLoading = false,connectionPassed = it)
                * }*/
            }
        }
    }

}