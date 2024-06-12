package com.berkaykurtoglu.recipequest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.berkaykurtoglu.recipequest.presentation.components.OfflineMode
import com.berkaykurtoglu.recipequest.presentation.navigation.RecipeQuestNavGraph
import com.berkaykurtoglu.recipequest.presentation.theme.RecipeQuestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            RecipeQuestTheme {
                Surface {
                    RecipeQuestNavGraph()
                }
            }
        }
    }

}
