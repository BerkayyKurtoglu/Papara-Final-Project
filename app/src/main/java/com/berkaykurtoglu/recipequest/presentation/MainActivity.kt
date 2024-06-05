package com.berkaykurtoglu.recipequest.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import com.berkaykurtoglu.recipequest.presentation.navigation.RecipeQuestNavGraph
import com.berkaykurtoglu.recipequest.presentation.splashscreen.SplashScreenViewModel
import com.berkaykurtoglu.recipequest.presentation.theme.RecipeQuestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreenViewModel by viewModels<SplashScreenViewModel>()
        splashScreenViewModel.checkNetworkAvailability()
        installSplashScreen().setKeepOnScreenCondition(
            condition = {
                splashScreenViewModel.screenState.value.isLoading
            }
        )
        enableEdgeToEdge()
        setContent {
            val state = splashScreenViewModel.screenState.collectAsState()
            RecipeQuestTheme {
                if (!state.value.isLoading){
                    RecipeQuestNavGraph(isNetworkAvailable = state.value.connectionPassed)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecipeQuestTheme {
        Greeting("Android")
    }
}