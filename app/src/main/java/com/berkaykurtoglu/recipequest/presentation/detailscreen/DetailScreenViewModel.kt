package com.berkaykurtoglu.recipequest.presentation.detailscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkaykurtoglu.recipequest.data.mapextension.toRecipeDetailEntity
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.RecipeDetailModel
import com.berkaykurtoglu.recipequest.domain.usecase.UseCase
import com.berkaykurtoglu.recipequest.util.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val useCase : UseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow(DetailScreenState())
    val screenState = _screenState.asStateFlow()

    fun onEvent(event: DetailScreenEvent) {
        when(event){
            is DetailScreenEvent.OnAddFavorite -> {
                TODO("Add Favorite in Cache")
            }

            is DetailScreenEvent.OnGetRecipeById -> {
                getRecipeByIdFromNetwork(event.id)
            }

            is DetailScreenEvent.OnAddCache -> {
                saveRecipeToCache(event.recipe)
            }
        }
    }

    private fun saveRecipeToCache(
        recipe : RecipeDetailModel?
    ){
        viewModelScope.launch {
            val count = async { useCase.getCacheCountUseCase() }.await()
            if (count<50){
                recipe?.let {
                    useCase.saveRecipeToCacheUseCase(recipe.toRecipeDetailEntity())
                }
            }else{
                //Todo : Delete Oldest Recipe Then Add
                val oldestRecipe = async { useCase.getOldestUseCase() }.await()
                val deletedCount = async{ useCase.deleteRecipeFromCache(oldestRecipe.id) }.await()
                if (deletedCount == 1) {
                    recipe?.let {
                        useCase.saveRecipeToCacheUseCase(recipe.toRecipeDetailEntity())
                    }
                }
            }
        }
    }

    private fun getRecipeByIdFromNetwork(
        id : Int?
    ) {
        id?.let {
            viewModelScope.launch {
                useCase.getRecipeByIdFromNetworkUseCase(id).collect{ apiResult->

                    when(apiResult){
                        is ApiResult.Error -> {
                            _screenState.update {
                                it.copy(
                                    errorMessage = apiResult.message,
                                    isLoading = false,
                                    data = null
                                )
                            }
                        }
                        ApiResult.Loading -> {
                            _screenState.update {
                                it.copy(
                                    isLoading = true,
                                    errorMessage = "",
                                    data = null
                                )
                            }
                        }
                        is ApiResult.Success -> {
                            _screenState.update {
                                it.copy(
                                    data = apiResult.data.toRecipeDetailModel(),
                                    isLoading = false,
                                    errorMessage = ""
                                )
                            }
                            saveRecipeToCache(apiResult.data.toRecipeDetailModel())
                        }
                    }

                }
            }
        } ?:{
            _screenState.update {
                it.copy(
                    errorMessage = "Something went wrong"
                )
            }
        }
    }



}