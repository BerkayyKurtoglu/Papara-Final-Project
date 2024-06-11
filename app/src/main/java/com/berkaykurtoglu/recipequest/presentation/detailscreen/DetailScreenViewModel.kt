package com.berkaykurtoglu.recipequest.presentation.detailscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkaykurtoglu.recipequest.data.mapextension.toRecipeDetailEntity
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.RecipeDetailModel
import com.berkaykurtoglu.recipequest.domain.usecase.UseCase
import com.berkaykurtoglu.recipequest.presentation.navigation.Screens
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
                handleOnFavorite()
            }

            is DetailScreenEvent.OnGetRecipeById -> {
                if(event.isNetworkAvailable) getRecipeByIdFromNetwork(event.id)
                else {
                    handleOnOffline(event.id,event.comingScreenId)
                }
            }
        }
    }

    private fun handleOnFavorite(){
        if(!_screenState.value.isLoading && _screenState.value.errorMessage.isBlank()){
            if(!_screenState.value.isFavorite) saveRecipeToFavorite()
            else deleteRecipeFromFavorite()
        }
    }

    private fun handleOnOffline(
        recipeId : Int?,
        screenId : Int?
    ){

        if (recipeId != null && screenId != null){
            if (screenId == 1){
                //Coming From Home
                getRecipeFromCache(recipeId)
            }else{
                // coming favorite
                getRecipeFromFavorite(recipeId)
            }
        }else{
            _screenState.value = _screenState.value.copy(
                errorMessage = "Something went wrong",
                isLoading = false,
                data = null
            )
        }
    }

    private fun deleteRecipeFromFavorite(){
        viewModelScope.launch {
            val id = async { useCase.deleteRecipeFromFavoriteUseCase(_screenState.value.data!!.id) }.await()
            if (id > 0) {
                _screenState.update {
                    it.copy(
                        isFavorite = false
                    )
                }
            }
        }
    }

    private fun getRecipeFromFavorite(
        id : Int
    ){

        viewModelScope.launch {
            useCase.getRecipeByIdFromFavoriteUseCase(id).collect{result->
                when(result){
                    is ApiResult.Error -> {
                        _screenState.update {
                            it.copy(
                                errorMessage = result.message,
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
                                data = result.data.toRecipeDetailModel(),
                                isLoading = false,
                                errorMessage = "",
                                isFavorite = true
                            )
                        }
                    }
                }
            }
        }

    }

    private fun getRecipeFromCache(
        id : Int
    ){
        id.let {
            viewModelScope.launch {
                useCase.getRecipeByIdFromFavoriteUseCase(id).collect{result->
                    when(result) {
                        is ApiResult.Success -> {
                            if (result.data == null) {
                                _screenState.update {
                                    it.copy(
                                        isFavorite = false
                                    )
                                }
                            }else {
                                _screenState.update {
                                    it.copy(
                                        isFavorite = true
                                    )
                                }
                            }
                        }
                        else -> {}
                    }
                }
                useCase.getRecipeByIdFromCacheUseCase(id).collect{result->
                    when(result){
                        is ApiResult.Error -> {
                            _screenState.update {
                                it.copy(
                                    isLoading = false,
                                    errorMessage = it.errorMessage,
                                    data = null)
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
                                    data = result.data.toRecipeDetailModel(),
                                    isLoading = false,
                                    errorMessage = ""
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun saveRecipeToFavorite(){

        viewModelScope.launch {
            if(!_screenState.value.isLoading && _screenState.value.errorMessage.isBlank()){
                val id =  async { useCase.insertRecipeToFavoriteUseCase(_screenState.value.data!!.toRecipeDetailEntity()) }.await()
                if (id != -1L) {
                    _screenState.update {
                        it.copy(
                            isFavorite = true
                        )
                    }
                }
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