package com.berkaykurtoglu.recipequest.presentation.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.berkaykurtoglu.recipequest.presentation.components.CustomSearchBar
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope,
    isNetworkAvailable: Boolean,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
    onNavigateToDetail : () -> Unit
) {

    val searchText = remember {
        mutableStateOf("")
    }
    val searchIsActive = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = Unit) {
        homeScreenViewModel.onEvent(HomeScreenEvent.OnFirstCall(false))
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomSearchBar(
            active = searchIsActive,
            text = searchText,
            onSearch = {

            }
        ){

            

        }


    }


}


