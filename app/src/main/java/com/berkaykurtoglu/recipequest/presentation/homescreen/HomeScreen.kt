package com.berkaykurtoglu.recipequest.presentation.homescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.berkaykurtoglu.recipequest.R
import com.berkaykurtoglu.recipequest.domain.model.recipesmodel.RecipeModel
import com.berkaykurtoglu.recipequest.presentation.components.CustomCard
import com.berkaykurtoglu.recipequest.presentation.components.CustomSearchBar
import com.berkaykurtoglu.recipequest.presentation.components.FilterChips
import com.berkaykurtoglu.recipequest.presentation.components.SearchBarItem
import com.berkaykurtoglu.recipequest.presentation.navigation.Screens
import com.berkaykurtoglu.recipequest.util.FilterCategorie
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
    onNavigateToDetail : (id : Int, comingScreenId : Int) -> Unit,
    onNavigateToFavorite : () -> Unit
) {

    val searchText = remember {
        mutableStateOf("")
    }
    val searchIsActive = remember {
        mutableStateOf(false)
    }
    val filterList = mutableListOf(
        FilterCategorie.Random,
        FilterCategorie.BreakFast,
        FilterCategorie.MainCourse,
        FilterCategorie.SideDish,
        FilterCategorie.Dessert,
        FilterCategorie.Drink,
        FilterCategorie.Snack,
    )
    val lazyListState = rememberLazyListState()

    val screenState = homeScreenViewModel.screenState.collectAsState()

    val lazyPagingItems : LazyPagingItems<RecipeModel> = homeScreenViewModel.screenPagingState.collectAsLazyPagingItems()

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        CustomSearchBar(
            active = searchIsActive,
            text = searchText,
            onSearch = {
                homeScreenViewModel.onEvent(HomeScreenEvent.OnSearchRecipes(it))
            },
            onFavoriteClicked = {
                onNavigateToFavorite()
            }
        ){
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (screenState.value.searchIsLoading) CircularProgressIndicator()
                else if (screenState.value.searchErrorMessage.isNotBlank()){
                    Text(text = screenState.value.searchErrorMessage)
                }else{
                    LazyColumn(
                        contentPadding = PaddingValues(20.dp),
                        verticalArrangement = Arrangement.spacedBy(17.dp)
                    ) {
                        items(screenState.value.searchRecipesResult){
                            SearchBarItem(
                                modifier = Modifier.fillMaxWidth(),
                                recipe = it
                            ){id->
                                onNavigateToDetail(id,Screens.HomeScreen.id)
                            }
                        }
                    }
                }
            }

        }

        if (screenState.value.isNetworkConnected){
            FilterChips(
                filterList = filterList,
                selectedItem = screenState.value.chipIndex
            ) {
                homeScreenViewModel.onEvent(HomeScreenEvent.OnFilter(it))
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        Box(
            Modifier.weight(1f).fillMaxWidth()
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(18.dp),
                contentPadding = PaddingValues(horizontal = 25.dp),
                state = lazyListState,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
            ) {
                items(lazyPagingItems.itemCount){
                    CustomCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(13f / 9f)
                            .animateItemPlacement(),
                        recipeModel = lazyPagingItems[it]
                    ){id->
                        onNavigateToDetail(id,Screens.HomeScreen.id)
                    }
                }
                lazyPagingItems.apply {
                    when{
                        loadState.refresh is LoadState.Loading ->{
                            item{
                                CircularProgressIndicator()
                            }
                        }
                        loadState.refresh is LoadState.Error ->{
                            item{
                                Text(text = (loadState.refresh as LoadState.Error).error.message.toString(),Modifier.fillMaxSize())
                            }
                        }
                        loadState.append is LoadState.Loading ->{
                            item{
                                CircularProgressIndicator()
                            }
                        }
                        loadState.append is LoadState.Error ->{
                            item{
                                Text(text = (loadState.append as LoadState.Error).error.message.toString())
                            }
                        }
                    }
                }
            }
            IconButton(onClick = {
                homeScreenViewModel.onEvent(HomeScreenEvent.RefreshThePage)
            },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(20.dp)
                    .border(0.5.dp, color = Color.Gray, shape = CircleShape)
                    .background(Color.Black.copy(0.7f), CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.die),
                    contentDescription = "",
                    modifier = Modifier.padding(5.dp),
                    tint = Color.White
                )
            }

        }

    }


}


