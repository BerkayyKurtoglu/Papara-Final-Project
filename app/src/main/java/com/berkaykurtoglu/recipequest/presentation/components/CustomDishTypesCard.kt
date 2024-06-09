package com.berkaykurtoglu.recipequest.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DishTypesCard(
    modifier: Modifier = Modifier,
    dishType : String
) {

    Card {
        Text(
            text = dishType,
            modifier = Modifier.padding(10.dp)
        )
    }

}


