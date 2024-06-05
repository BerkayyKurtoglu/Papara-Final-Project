package com.berkaykurtoglu.recipequest.presentation.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.berkaykurtoglu.recipequest.presentation.components.CustomCard
import com.berkaykurtoglu.recipequest.presentation.components.CustomSearchBar
import com.berkaykurtoglu.recipequest.presentation.components.FilterChips
import com.berkaykurtoglu.recipequest.util.FilterCategorie
import kotlinx.coroutines.CoroutineScope

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
    val selectedChip = remember {
        mutableStateOf(false)
    }
    val filterList = listOf(
        FilterCategorie.All,
        FilterCategorie.BreakFast,
        FilterCategorie.Lunch,
        FilterCategorie.Dinner,
        FilterCategorie.DairyFree,
        FilterCategorie.GlutenFree,
        FilterCategorie.Vegetarian,
    )

    val screenState = homeScreenViewModel.screenState.collectAsState()

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
        Spacer(modifier = Modifier.height(12.dp))

        FilterChips(
            filterList = filterList,
            selectedItem = screenState.value.chipIndex) {
            homeScreenViewModel.updateChipIndex(it)
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(18.dp),
        ) {
            items(5){
                CustomCard(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                        .aspectRatio(13f / 9f),
                ){

                }
            }
        }


    }


}


