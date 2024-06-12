package com.berkaykurtoglu.recipequest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.berkaykurtoglu.recipequest.domain.model.recipesmodel.RecipeModel

@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    recipeModel : RecipeModel?,
    shape: RoundedCornerShape = RoundedCornerShape(20.dp),
    onNavigateToDetail : (id : Int) -> Unit
) {

    recipeModel?.let {

        Box(
            modifier = modifier.clickable {
                onNavigateToDetail(
                    recipeModel.id
                )
            }.fillMaxSize().aspectRatio(13f/9f)
        ) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(recipeModel.image)
                    .crossfade(true)
                    .build(),
                contentDescription = "Recipe Image",
                modifier = Modifier.fillMaxSize().clip(shape),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier= Modifier
                    .fillMaxSize()
                    .background(color = Color.Black.copy(0.5f), shape = shape),

                ){

                Row(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxWidth()
                        .padding(25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = recipeModel.sourceName,
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier,
                        fontWeight = FontWeight.Normal
                    )
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(25.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    Text(
                        text = recipeModel.title,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccessTime,
                            contentDescription = "Timer Icon",
                            tint = Color.White,
                            modifier = Modifier.size(23.dp)
                        )
                        Text(
                            text = recipeModel.readyInMinutes.toString() + " Min",
                            color = Color.White,
                            fontSize = 14.sp,
                            modifier = Modifier
                        )
                    }

                }



            }

        }

    }

}


