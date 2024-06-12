package com.berkaykurtoglu.recipequest.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.RecipeDetailModel
import com.berkaykurtoglu.recipequest.domain.model.recipesearchmodel.RecipeSearchModel
import com.berkaykurtoglu.recipequest.domain.model.recipesmodel.RecipeModel
import java.util.Date

@Entity("recipe_entity")
data class RecipeDetailEntity(
    val analyzedInstructionList: List<AnalyzedInstructionEntity>,
    val allergenList: List<AllergenEntity>,
    val dishTypes: List<String>,
    val extendedIngredientList: List<ExtendedIngredientEntity>,
    @PrimaryKey
    val id: Int,
    val image: String,
    val instructions: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceName: String,
    val sourceUrl: String,
    val spoonacularScore: Double,
    val summary: String,
    val title: String,
    val veryPopular: Boolean,
    val addedDate : Date
){

    fun toRecipeDetailModel() =
        RecipeDetailModel(
            analyzedInstructionList.map { it.toAnalyzedInstructionModel() },
            allergenList.map { it.toAllergenModel() },
            dishTypes,
            extendedIngredientList.map { it.toExtendedIngredientModel() },
            id,image,instructions,readyInMinutes,servings,sourceName,sourceUrl,spoonacularScore,summary,title,veryPopular)

    fun toRecipeModel() : RecipeModel =
        RecipeModel(sourceName, title, readyInMinutes, image, id)

    fun toRecipeSearchModel() : RecipeSearchModel =
        RecipeSearchModel(
            id = id,
            title = title
        )

}