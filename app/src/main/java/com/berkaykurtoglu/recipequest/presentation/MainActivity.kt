package com.berkaykurtoglu.recipequest.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import com.berkaykurtoglu.recipequest.presentation.components.OfflineMode
import com.berkaykurtoglu.recipequest.presentation.navigation.RecipeQuestNavGraph
import com.berkaykurtoglu.recipequest.presentation.splashscreen.SplashScreenViewModel
import com.berkaykurtoglu.recipequest.presentation.theme.RecipeQuestTheme
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.wait

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
                Surface {
                    if (!state.value.isLoading){
                        Box(
                            Modifier.fillMaxSize()
                        ) {
                            RecipeQuestNavGraph(isNetworkAvailable = state.value.connectionPassed)
                            OfflineMode(
                                modifier = Modifier.align(Alignment.BottomCenter)
                            )
                        }
                    }
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