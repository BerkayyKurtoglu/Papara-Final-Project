package com.berkaykurtoglu.recipequest.presentation.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.berkaykurtoglu.recipequest.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit
) {

    LaunchedEffect(key1 = Unit) {
        delay(2000)
        onNavigateToHome()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.main_background),
            contentDescription = "Main Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(RoundedCornerShape(20.dp))
        )
        Box(
            Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(0.5f))
        ) {
            Text(
                text = "Recipe Quest",
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.Center)
            )

            Column(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Network is testing",
                    color = Color.White,
                    fontSize = 16.sp,
                )
                CircularProgressIndicator(
                    color = Color.White,
                    modifier = Modifier
                        .size(20.dp),
                    strokeWidth = 3.dp
                )
            }

        }


    }


}


