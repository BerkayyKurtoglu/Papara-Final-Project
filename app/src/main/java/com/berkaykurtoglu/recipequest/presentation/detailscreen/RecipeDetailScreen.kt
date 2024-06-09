package com.berkaykurtoglu.recipequest.presentation.detailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.berkaykurtoglu.recipequest.R
import com.berkaykurtoglu.recipequest.presentation.components.CustomDetailCard
import com.berkaykurtoglu.recipequest.presentation.components.CustomTopBar
import com.berkaykurtoglu.recipequest.presentation.components.DetailItem
import kotlinx.coroutines.CoroutineScope

@Composable
fun RecipeDetailScreen(
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope,
    isNetworkAvailable: Boolean,
    recipeId : Int?,
    onBackClick: () -> Unit
) {


    Scaffold(
        topBar = {
            CustomTopBar(title = "Recipe") {
                onBackClick()
            }
        }
    ) {
        LazyColumn(
            Modifier.padding(it),
            contentPadding = PaddingValues(start = 25.dp, end = 25.dp, bottom = 25.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item{
                Image(
                    painter = painterResource(id = R.drawable.main_background),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(14f / 9f)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            item {
                Text(
                    text = "Toast With Egg And Cheese",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            }
            item {
                CustomDetailCard()
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(3) {
                        FilledTonalButton(onClick = { /*TODO*/ }, shape = RoundedCornerShape(12.dp)) {
                            Text(text = "Egg")
                        }
                    }
                }
            }
            item {
                Text(
                    text = "Ingredients",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            }
            items(20){
                DetailItem()
            }
        }
    }


}


