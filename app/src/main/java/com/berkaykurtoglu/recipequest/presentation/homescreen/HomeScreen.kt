package com.berkaykurtoglu.recipequest.presentation.homescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.berkaykurtoglu.recipequest.presentation.components.CustomCard
import com.berkaykurtoglu.recipequest.presentation.components.CustomSearchBar
import com.berkaykurtoglu.recipequest.presentation.components.FilterChips
import com.berkaykurtoglu.recipequest.presentation.components.NotConnectedBar
import com.berkaykurtoglu.recipequest.util.FilterCategorie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope,
    isNetworkAvailable: Boolean,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
    onNavigateToDetail : (id : Int) -> Unit
) {

    val searchText = remember {
        mutableStateOf("")
    }
    val searchIsActive = remember {
        mutableStateOf(false)
    }
    val filterList = mutableListOf(
        FilterCategorie.Random,
        FilterCategorie.DairyFree,
        FilterCategorie.GlutenFree,
        FilterCategorie.Vegetarian,
    )
    val lazyListState = rememberLazyListState()

    val screenState = homeScreenViewModel.screenState.collectAsState()



    LaunchedEffect(key1 = Unit) {
        if (screenState.value.firstCall){
            homeScreenViewModel.onEvent(HomeScreenEvent.OnFetchRecipes(isNetworkAvailable, offset = 0))
        }else{
            //homeScreenViewModel.onEvent(HomeScreenEvent.OnFilter(screenState.value.chipIndex))
        }
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (screenState.value.isLoading){
            CircularProgressIndicator()
        }else if(screenState.value.errorMessage.isNotBlank()){
            Text(text = screenState.value.errorMessage)
        }else if(screenState.value.recipes.resultModels?.isEmpty() == true){
            FilledTonalButton(onClick = {
                homeScreenViewModel.onEvent(HomeScreenEvent.OnFetchRecipes(isNetworkAvailable, offset = 10))
            }) {
                Text(text = "We could not find any recipes :(")
            }
        }else{

            CustomSearchBar(
                active = searchIsActive,
                text = searchText,
                onSearch = {

                }
            ){


            }
            if (isNetworkAvailable) NotConnectedBar(modifier = Modifier.width(250.dp))
            Spacer(modifier = Modifier.height(12.dp))

            FilterChips(
                filterList = if (false){
                    filterList.add(FilterCategorie.BreakFast)
                    filterList.add(FilterCategorie.Lunch)
                    filterList.add(FilterCategorie.Dinner)
                    filterList } else {filterList},
                selectedItem = screenState.value.chipIndex) {
                homeScreenViewModel.onEvent(HomeScreenEvent.OnFilter(it))
            }

            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(18.dp),
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 25.dp),
                state = lazyListState,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                screenState.value.recipes.resultModels?.let {resultModelList->
                    items(
                        resultModelList,
                        key = {
                            it.id
                        }
                    ){
                        CustomCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(13f / 9f)
                                .animateItemPlacement(),
                            resultModel = it,
                            onClickFavorite = {}
                        ){id->
                            onNavigateToDetail(id)
                        }
                    }
                    if (false){
                        item{
                            IconButton(onClick = {
                                val oldOffset = screenState.value.recipes.offset
                                oldOffset?.let {
                                    homeScreenViewModel.onEvent(HomeScreenEvent.OnFetchRecipes(true, offset = it + 10))
                                }

                            }) {
                                Icon(imageVector = Icons.Default.Add, contentDescription = "")
                            }
                        }
                    }
                }
            }
        }
    }


}


