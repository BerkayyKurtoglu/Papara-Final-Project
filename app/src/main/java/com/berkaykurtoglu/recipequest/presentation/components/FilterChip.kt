package com.berkaykurtoglu.recipequest.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.berkaykurtoglu.recipequest.util.FilterCategorie


@Composable
fun FilterChips(
    modifier: Modifier = Modifier,
    filterList : List<FilterCategorie>,
    selectedItem : FilterCategorie,
    onFilterSelected : (FilterCategorie) -> Unit
) {

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 20.dp)
    ) {
        items(filterList){
            FilterChip(
                selected = it == selectedItem,
                onClick = {
                    onFilterSelected(it)
                },
                label = {
                    Text(text = it.category)
                }
            )
        }
    }


}

