package com.berkaykurtoglu.recipequest.presentation.detailscreen

import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.berkaykurtoglu.recipequest.presentation.components.AllergenDetailCard
import com.berkaykurtoglu.recipequest.presentation.components.CustomTabRow
import com.berkaykurtoglu.recipequest.presentation.components.CustomTopBar
import com.berkaykurtoglu.recipequest.presentation.components.DishTypesCard
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeDetailScreen(
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope,
    isNetworkAvailable: Boolean,
    recipeId : Int?,
    viewModel: DetailScreenViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {

    val screenState = viewModel.screenState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(DetailScreenEvent.OnGetRecipeById(recipeId))
    }

    Scaffold(
        topBar = {
            CustomTopBar(title = "Recipe Quest") {
                onBackClick()
            }
        }
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (screenState.value.isLoading){
                CircularProgressIndicator()
            }else if(screenState.value.errorMessage.isNotBlank()){
                Text(text = screenState.value.errorMessage)
            }else if(screenState.value.data != null){
                LazyColumn(
                    Modifier.padding(it),
                    contentPadding = PaddingValues(start = 25.dp, end = 25.dp, bottom = 25.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item{

                        AsyncImage(
                            model = screenState.value.data!!.image,
                            contentDescription = "Recipe Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(14f / 9f)
                                .clip(RoundedCornerShape(20.dp)),
                            contentScale = ContentScale.Crop
                        )

                    }
                    item {
                        Text(
                            text = screenState.value.data!!.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                    item{
                        AndroidView(factory = {
                                TextView(it).apply {
                                    textSize = 16f
                                    movementMethod = LinkMovementMethod.getInstance()
                                    setLineSpacing(16f,1f)
                                }
                                              },
                            update = {
                                it.text = HtmlCompat.fromHtml(screenState.value.data!!.summary, HtmlCompat.FROM_HTML_MODE_COMPACT)
                            }
                        )
                    }
                    item {
                        AllergenDetailCard(allergenList = screenState.value.data!!.allergenList)
                    }
                    if(screenState.value.data!!.dishTypes.isNotEmpty()){
                        item {
                            LazyRow(
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                items(screenState.value.data!!.dishTypes) {
                                    DishTypesCard(dishType = it)
                                }
                            }
                        }
                    }

                    item{
                        CustomTabRow(
                            coroutineScope = coroutineScope,
                            ingredients = screenState.value.data!!.extendedIngredientModels,
                            instructionSteps = screenState.value.data!!.analyzedInstructionModels[0].stepModels
                        )
                    }

                    /*item {
                        Text(
                            text = "Ingredients",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                    items(screenState.value.data!!.extendedIngredientModels){
                        DetailItem(
                            modifier = Modifier,
                            extendedIngredientModel = it
                        )
                    }*/
                }
            }
        }
    }


}


