package com.berkaykurtoglu.recipequest.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.ExtendedIngredientModel


@Composable
fun IngredientsView(
    modifier: Modifier = Modifier,
    extendedIngredientModel: ExtendedIngredientModel
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.width(10.dp))
        Text(text = extendedIngredientModel.name)

        Spacer(modifier = Modifier.weight(1f))
        Text(text = "${extendedIngredientModel.amount} ${extendedIngredientModel.unit}")

    }

}


