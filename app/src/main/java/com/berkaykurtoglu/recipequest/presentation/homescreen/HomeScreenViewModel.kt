package com.berkaykurtoglu.recipequest.presentation.homescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkaykurtoglu.recipequest.data.mapextension.toModel
import com.berkaykurtoglu.recipequest.domain.usecase.UseCase
import com.berkaykurtoglu.recipequest.util.ApiResult
import com.berkaykurtoglu.recipequest.util.FilterCategorie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val useCase : UseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow(HomeScreenState())
    val screenState = _screenState.asStateFlow()


    fun onEvent(
        event : HomeScreenEvent
    ){
        when(event){
            is HomeScreenEvent.OnFirstCall ->{
                if (event.isConnected) getRecipesFromNetwork()
                else getRecipesFromDatabase()
            }
        }
    }

    fun updateChipIndex(filterCategorie: FilterCategorie){
        _screenState.value = _screenState.value.copy(chipIndex = filterCategorie)
    }

    private fun getRecipesFromNetwork() {
        viewModelScope.launch {
            useCase.getAllRecipesRandomlyUseCase().collect{apiResult ->
                   when(apiResult) {

                       is ApiResult.Loading ->{
                           println("loading")
                       }
                       is ApiResult.Error ->{
                           println(apiResult.message)
                       }
                       is ApiResult.Success ->{
                            apiResult.data.results.forEach {
                                println(it.title)
                            }
                       }

                   }
            }
        }
    }

    private fun getRecipesFromDatabase(){
        _screenState.update {
            it.copy(
                isLoading = true,
                errorMessage = ""
            )
        }
        viewModelScope.launch {
            delay(1000)
            useCase.getAllRecipesFromLocalUseCase().collect{localResponseList ->
                _screenState.update {
                    it.copy(
                        isLoading = false,
                        recipes = localResponseList.toModel(),
                        errorMessage = ""
                    )
                }
            }
        }
    }


}