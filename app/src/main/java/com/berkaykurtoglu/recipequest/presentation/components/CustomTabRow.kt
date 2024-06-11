package com.berkaykurtoglu.recipequest.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.AnalyzedInstructionModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.ExtendedIngredientModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.StepModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CustomTabRow(
    modifier : Modifier = Modifier,
    coroutineScope: CoroutineScope,
    ingredients: List<ExtendedIngredientModel>,
    instructionSteps: List<StepModel>
) {

    val tabs = listOf("Ingredients", "Instructions")
    val pagerState = rememberPagerState {
        2
    }

    Column(
        modifier = modifier
    ) {
        PrimaryTabRow(
            selectedTabIndex = pagerState.currentPage,
            divider = {}
        ) {
            tabs.forEachIndexed{index, title ->
                Tab(
                    selected = pagerState.currentPage==index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    modifier = Modifier.padding(vertical = 10.dp),
                    unselectedContentColor = Color.Gray
                ) {
                    Text(
                        text = tabs[index]
                    )
                }
            }
        }

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(vertical = 15.dp),
            pageSpacing = 10.dp
        ) {page->
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                when(page){
                    0 -> {
                        if (ingredients.isNotEmpty()){
                            ingredients.forEach {
                                IngredientsView(extendedIngredientModel = it)
                            }
                        }else{
                            Text(
                                text = "No Ingredients Data Found"
                            )
                        }
                    }
                    1 -> {
                        if (instructionSteps.isNotEmpty()){
                            instructionSteps.forEach {step->
                                Text(
                                    text = buildAnnotatedString {
                                        withStyle(
                                            style = SpanStyle(
                                                color = Color.Black,
                                                fontWeight = FontWeight.Bold,
                                            )
                                        ){
                                            append("${step.number} - ")
                                        }
                                        append(step.step)
                                    }
                                )
                            }
                        }else{
                            Text(
                                text = "No Instruction Data Found"
                            )
                        }
                    }
                }
            }
        }
    }


}