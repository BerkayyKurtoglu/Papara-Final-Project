package com.berkaykurtoglu.recipequest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun OfflineMode(
    modifier: Modifier = Modifier
) {

    Row(
        modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.onBackground.copy(0.65f)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Offline Mode",
            color = MaterialTheme.colorScheme.background,
        )
    }

}

