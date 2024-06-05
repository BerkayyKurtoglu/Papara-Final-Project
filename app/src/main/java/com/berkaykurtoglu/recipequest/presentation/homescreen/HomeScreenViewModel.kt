package com.berkaykurtoglu.recipequest.presentation.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkaykurtoglu.recipequest.domain.usecase.UseCase
import com.berkaykurtoglu.recipequest.util.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val useCase : UseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow(HomeScreenState())
    val screenState = _screenState.asStateFlow()

    fun getRecipes() {
        viewModelScope.launch {
            useCase.getAllRecipesRandomlyUseCase().collect{apiResult ->
                   when(apiResult) {

                       is ApiResult.Loading ->{
                           println("loading")
                       }
                       is ApiResult.Error ->{
                           println("error")
                       }
                       is ApiResult.Success ->{

                       }

                   }
            }
        }
    }


}