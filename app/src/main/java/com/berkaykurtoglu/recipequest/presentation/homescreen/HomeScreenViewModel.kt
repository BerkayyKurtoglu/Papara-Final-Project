package com.berkaykurtoglu.recipequest.presentation.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.berkaykurtoglu.recipequest.domain.model.recipesmodel.RecipeModel
import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import com.berkaykurtoglu.recipequest.domain.usecase.UseCase
import com.berkaykurtoglu.recipequest.util.ApiResult
import com.berkaykurtoglu.recipequest.util.FilterCategorie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel()
class HomeScreenViewModel @Inject constructor(
    private val useCase : UseCase,
    private val homeRepository: HomeRepository,
) : ViewModel() {

    private val _screenState = MutableStateFlow(HomeScreenState())
    val screenState = _screenState.asStateFlow()

    val screenPagingState : MutableStateFlow<PagingData<RecipeModel>> = MutableStateFlow(PagingData.empty())

    init {
        fetchRecipes()
    }

    fun onEvent(
        event : HomeScreenEvent
    ){
        when(event){
            is HomeScreenEvent.OnFilter ->{
                updateChipIndex(event.filter)
                getPagingDataFromNetwork(event.filter)
            }

            is HomeScreenEvent.OnSearchRecipes -> {
                handleSearchEvent(
                    query = event.query
                )
            }

            HomeScreenEvent.RefreshThePage -> fetchRecipes()
        }
    }

    private fun handleSearchEvent(
        query : String
    ){
        if (_screenState.value.isNetworkConnected) searchRecipesFromNetwork(query)
        else searchRecipesFromCache(query)
    }

    private fun searchRecipesFromCache(
        query : String
    ){
        viewModelScope.launch {
            useCase.searchRecipeFromCacheUseCase(query).collect{result->
                when(result) {
                    is ApiResult.Error -> {
                        _screenState.value = _screenState.value.copy(
                            searchIsLoading = false,
                            searchErrorMessage = result.message
                        )
                    }
                    ApiResult.Loading -> {
                        _screenState.value = _screenState.value.copy(
                            searchIsLoading = true,
                            searchErrorMessage = ""
                        )
                    }
                    is ApiResult.Success -> {
                        _screenState.value = _screenState.value.copy(
                            searchIsLoading = false,
                            searchRecipesResult = result.data.map { it.toRecipeSearchModel() }
                        )
                    }
                }
            }
        }
    }

    private fun fetchRecipes(){
        viewModelScope.launch {
            useCase.checkNetworkUseCase().collect{connected ->
                _screenState.update {
                    it.copy(isNetworkConnected = connected)
                }
                if(connected) getPagingDataFromNetwork(
                    _screenState.value.chipIndex
                )
                else getRecipesFromCache()
            }
        }
    }

    private fun searchRecipesFromNetwork(
        query : String
    ){
        viewModelScope.launch {
            useCase.searchRecipesFromNetworkUseCase(query).collect{result->
                when(result){
                    is ApiResult.Error -> {
                        _screenState.value = _screenState.value.copy(
                            searchIsLoading = false,
                            searchErrorMessage = result.message
                        )
                    }
                    ApiResult.Loading -> {
                        _screenState.value = _screenState.value.copy(
                            searchIsLoading = true,
                            searchErrorMessage = ""
                        )
                    }
                    is ApiResult.Success -> {
                        _screenState.value = _screenState.value.copy(
                            searchIsLoading = false,
                            searchRecipesResult = result.data.toRecipeSearchModelList()
                        )
                    }
                }
            }
        }
    }

    private fun getPagingDataFromNetwork(
        mealType: FilterCategorie
    ){
        viewModelScope.launch {
            useCase.getAllRecipesFromNetworkUseCase(
                when(mealType){
                    is FilterCategorie.Random -> ""
                    else -> mealType.category
                }
            ).distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect{
                    screenPagingState.value = it
                }
        }
    }

    private fun updateChipIndex(filterCategorie: FilterCategorie){
        _screenState.value = _screenState.value.copy(chipIndex = filterCategorie)
    }


    private fun getRecipesFromCache(){
        viewModelScope.launch {
            useCase.getAllRecipesFromCache()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect{pagingData->
                    screenPagingState.value = pagingData
                }
        }
    }

}