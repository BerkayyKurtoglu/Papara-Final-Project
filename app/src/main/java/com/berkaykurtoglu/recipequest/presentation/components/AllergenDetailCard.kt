package com.berkaykurtoglu.recipequest.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.AllergenModel

@Composable
fun AllergenDetailCard(
    modifier: Modifier = Modifier,
    allergenList: List<AllergenModel>
) {

    OutlinedCard(
        modifier = modifier.fillMaxWidth(),
    ) {
        LazyRow(
            modifier = Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(allergenList) {
                AllergenDetailItem(allergen = it)
            }
        }
    }
}

@Composable
private fun AllergenDetailItem(
    modifier: Modifier = Modifier,
    allergen: AllergenModel
){
    Text(
        text = allergen.name,
        color = if (allergen.contains) MaterialTheme.colorScheme.surfaceTint else Color.Gray,
    )
}



