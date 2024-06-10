package com.berkaykurtoglu.recipequest.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    active : MutableState<Boolean>,
    text : MutableState<String>,
    onSearch : (String) -> Unit,
    onFavoriteClicked : () ->Unit,
    content : @Composable ColumnScope.() -> Unit
) {

    SearchBar(
        query = text.value,
        onQueryChange = {
            text.value = it
        },
        onSearch = {
            active.value = false
        },
        active = active.value,
        onActiveChange = {
            active.value = it
        },
        modifier = Modifier,
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search")},
        trailingIcon = {
            if(active.value){
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    modifier = Modifier.clickable {
                        if(text.value.isNotBlank()) text.value = ""
                        else active.value = false
                    }
                )
            }else{
                IconButton(
                    onClick = { onFavoriteClicked() },
                    modifier = Modifier.border(BorderStroke(1.dp, Color.Gray), shape = CircleShape)
                ) {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Fav")
                }
            }
        },
        placeholder = {
            Text(text = "Search Any Recipe..")
        }
    ) {
        content()
    }

}


