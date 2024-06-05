package com.berkaykurtoglu.recipequest.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    active : MutableState<Boolean>,
    text : MutableState<String>,
    onSearch : (String) -> Unit,
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
            }
        },
        placeholder = {
            Text(text = "Search Any Recipe..")
        }
    ) {
        content()
    }

}


