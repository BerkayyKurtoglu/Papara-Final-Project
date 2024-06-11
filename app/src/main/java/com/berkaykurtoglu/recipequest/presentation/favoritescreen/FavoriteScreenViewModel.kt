package com.berkaykurtoglu.recipequest.presentation.favoritescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkaykurtoglu.recipequest.domain.usecase.UseCase
import com.berkaykurtoglu.recipequest.util.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteScreenViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow(FavoriteScreenState())
    val screenState = _screenState.asStateFlow()

    init {
        getAllFavorites()
    }

    private fun getAllFavorites(){
        viewModelScope.launch {
            useCase.getAllFavoritesUseCase().collect{result ->
                when(result){
                    is ApiResult.Error -> {
                        _screenState.value = _screenState.value.copy(
                            isLoading = false, errorMessage = result.message, favorites = listOf()
                        )
                    }
                    ApiResult.Loading -> {
                        _screenState.value = _screenState.value.copy(
                            isLoading = true, errorMessage = "", favorites = listOf()
                        )
                    }
                    is ApiResult.Success -> {
                        _screenState.value = _screenState.value.copy(
                            isLoading = false, errorMessage = "", favorites = result.data.map { it.toRecipeDetailModel() }
                        )
                    }
                }
            }
        }
    }



}