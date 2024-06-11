package com.berkaykurtoglu.recipequest.presentation.favoritescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.berkaykurtoglu.recipequest.presentation.components.FavoriteCardItem
import com.berkaykurtoglu.recipequest.presentation.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteScreenViewModel = hiltViewModel(),
    onNavigateToDetail: (Int, comingScreenId : Int) -> Unit
) {

    val screenState = viewModel.screenState.collectAsState()
    val lazyListState = rememberLazyListState()

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row(Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Favorites")
                    Spacer(modifier = Modifier.weight(1f))
                }
            })
        }
    ) {
        if (screenState.value.isLoading) {
            CircularProgressIndicator()
        }
        if (screenState.value.errorMessage.isNotBlank()){
            Text(text = screenState.value.errorMessage)
        }
        if (screenState.value.favorites.isEmpty()){
            Text(text = "You Have No Favorites Now")
        }
        if (!screenState.value.isLoading && screenState.value.errorMessage.isBlank()){
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 25.dp),
                state = lazyListState,
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                items(
                    screenState.value.favorites,
                    key = {it.id},
                ){
                    FavoriteCardItem(recipe = it){
                        onNavigateToDetail(it,Screens.FavoriteScreen.id)
                    }
                }
            }
        }
    }


}

