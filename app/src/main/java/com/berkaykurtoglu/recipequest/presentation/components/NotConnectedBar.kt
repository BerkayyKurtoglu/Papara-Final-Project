package com.berkaykurtoglu.recipequest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotConnectedBar(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier.background(Color.Black.copy(0.8f), shape = RoundedCornerShape(
            bottomStart = 20.dp, bottomEnd = 20.dp
        ))
    ) {

        Text(
            text = "You are in offline mode now.",
            modifier = Modifier.align(Alignment.Center),
            color = Color.White,
            fontSize = 12.sp
        )

    }

}

