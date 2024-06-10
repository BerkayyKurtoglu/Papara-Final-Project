package com.berkaykurtoglu.recipequest.data.mapextension

import com.berkaykurtoglu.recipequest.data.source.local.entity.AllergenEntity
import com.berkaykurtoglu.recipequest.data.source.local.entity.AnalyzedInstructionEntity
import com.berkaykurtoglu.recipequest.data.source.local.entity.ExtendedIngredientEntity
import com.berkaykurtoglu.recipequest.data.source.local.entity.IngredientEntity
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.data.source.local.entity.StepEntity
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.AllergenModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.AnalyzedInstructionModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.ExtendedIngredientModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.IngredientModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.RecipeDetailModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.StepModel
import java.util.Date


fun RecipeDetailModel.toRecipeDetailEntity() =
    RecipeDetailEntity(
        analyzedInstructionList = analyzedInstructionModels.map { it.toAnalyzedInstructionEntity() },
        allergenList = allergenList.map { it.toAllergenEntity() },
        dishTypes = dishTypes,
        extendedIngredientList = extendedIngredientModels.map { it.toExtendedIngredientEntity() },
        id = id,
        image = image,
        instructions = instructions,
        readyInMinutes = readyInMinutes,
        servings = servings,
        sourceName = sourceName,
        sourceUrl = sourceUrl,
        title = title,
        veryPopular = veryPopular,
        summary = summary,
        spoonacularScore = spoonacularScore,
        addedDate = Date()
    )

fun AnalyzedInstructionModel.toAnalyzedInstructionEntity() =
    AnalyzedInstructionEntity(
        name = name,
        stepModels = stepModels.map { it.toStepEntity() }
    )
fun AllergenModel.toAllergenEntity() =
    AllergenEntity(
        name = name,
        contains = contains
    )
fun ExtendedIngredientModel.toExtendedIngredientEntity() =
    ExtendedIngredientEntity(
        id = id,
        image = image,
        name = name,
        aisle = aisle,
        amount = amount,
        unit = unit,
        nameClean = nameClean,
        original = original,
        originalName = originalName,
        consistency = consistency
    )
fun StepModel.toStepEntity() =
    StepEntity(
        ingredientModels = ingredientModels.map { it.toIngredientEntity() },
        number = number,
        step = step
    )
fun IngredientModel.toIngredientEntity() =
    IngredientEntity(
        id = id,
        image = image,
        name = name,
        localizedName = localizedName
    )
