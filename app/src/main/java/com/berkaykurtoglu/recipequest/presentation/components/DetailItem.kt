package com.berkaykurtoglu.recipequest.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.berkaykurtoglu.recipequest.R
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.ExtendedIngredientModel


@Composable
fun DetailItem(
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


