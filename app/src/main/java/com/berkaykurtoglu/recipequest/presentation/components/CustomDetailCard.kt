package com.berkaykurtoglu.recipequest.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomDetailCard(
    modifier: Modifier = Modifier
) {

    OutlinedCard(
        modifier = modifier
    ) {

        Row(
            Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(0.1.dp)
            ) {
                Text(
                    text = "360",
                    color = MaterialTheme.colorScheme.surfaceTint,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Kcal",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(0.1.dp)
            ) {
                Text(
                    text = "360",
                    color = MaterialTheme.colorScheme.surfaceTint,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Kcal",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(0.1.dp)
            ) {
                Text(
                    text = "360",
                    color = MaterialTheme.colorScheme.surfaceTint,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Kcal",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(0.1.dp)
            ) {
                Text(
                    text = "360",
                    color = MaterialTheme.colorScheme.surfaceTint,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Kcal",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

        }

    }


}


