package com.berkaykurtoglu.recipequest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.berkaykurtoglu.recipequest.domain.model.recipesearchmodel.RecipeSearchModel


@Composable
fun SearchBarItem(
    modifier: Modifier = Modifier,
    recipe : RecipeSearchModel = RecipeSearchModel(id = 1,title = "Test Test"),
    onItemClicked : (id : Int) -> Unit
) {

    Row(
        modifier = modifier
            .clickable { onItemClicked(recipe.id)},
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xF1CFCFCF), shape = CircleShape)
                .padding(6.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        }
        Text(
            text = recipe.title,
            fontSize = 15.sp
        )

    }

}


