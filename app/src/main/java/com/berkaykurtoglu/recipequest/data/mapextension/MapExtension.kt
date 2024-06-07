package com.berkaykurtoglu.recipequest.data.mapextension

import com.berkaykurtoglu.recipequest.data.source.local.entity.LocalRecipeResponse
import com.berkaykurtoglu.recipequest.data.source.remote.dto.Ingredient
import com.berkaykurtoglu.recipequest.data.source.remote.dto.NutrientX
import com.berkaykurtoglu.recipequest.data.source.remote.dto.Nutrition
import com.berkaykurtoglu.recipequest.data.source.remote.dto.RecipeResponseDto
import com.berkaykurtoglu.recipequest.data.source.remote.dto.Result
import com.berkaykurtoglu.recipequest.domain.model.IngredientModel
import com.berkaykurtoglu.recipequest.domain.model.NutrientXModel
import com.berkaykurtoglu.recipequest.domain.model.NutritionModel
import com.berkaykurtoglu.recipequest.domain.model.RecipeModel
import com.berkaykurtoglu.recipequest.domain.model.ResultModel

fun RecipeResponseDto.toLocal() : List<LocalRecipeResponse> =
    this.results.map {result->
        LocalRecipeResponse(
            id = result.id,
            cookingMinutes = result.cookingMinutes,
            dairyFree = result.dairyFree,
            glutenFree = result.glutenFree,
            healthScore = result.healthScore,
            image = result.image,
            imageType = result.imageType,
            lowFodmap = result.lowFodmap,
            preparationMinutes = result.preparationMinutes,
            readyInMinutes = result.readyInMinutes,
            servings = result.servings,
            sourceName = result.sourceName,
            sourceUrl = result.sourceUrl,
            summary = result.summary,
            title = result.title,
            vegan = result.vegan,
            vegetarian = result.vegetarian,
            veryHealthy = result.veryHealthy,
            veryPopular = result.veryPopular,
            calorieAmount = result.nutrition.nutrients[0].amount,
            calorieUnit = result.nutrition.nutrients[0].unit,
            fatAmount = result.nutrition.nutrients[1].amount,
            fatUnit = result.nutrition.nutrients[1].unit,
            proteinAmount = result.nutrition.nutrients[8].amount,
            proteinUnit = result.nutrition.nutrients[8].unit,
            carbohydrateAmount = result.nutrition.nutrients[3].amount,
            carbohydrateUnit = result.nutrition.nutrients[3].unit
        )
    }

fun RecipeResponseDto.toModel() : RecipeModel =
    RecipeModel(
        number = this.number,
        offset = this.offset,
        resultModels = this.results.map { it.toResultModel() }, // Map 'results' to 'resultModels'
        totalResults = this.totalResults
    )


fun List<LocalRecipeResponse>.toModel(): RecipeModel
    = RecipeModel(
        number = null,
        offset = null,
        resultModels = this.map { it.toResultModel() },
        totalResults = null
    )

fun LocalRecipeResponse.toResultModel() : ResultModel
    = ResultModel(
    id = this.id,
    cookingMinutes = this.cookingMinutes,
    title = this.title,
    image = this.image,
    imageType = this.imageType,
    summary = this.summary,
    servings = this.servings,
    readyInMinutes = this.readyInMinutes,
    preparationMinutes = this.preparationMinutes,
    healthScore = this.healthScore,
    vegan = this.vegan,
    vegetarian = this.vegetarian,
    veryHealthy = this.veryHealthy,
    veryPopular = this.veryPopular,
    cheap = null,
    creditsText = null,
    cuisines = null,
    dairyFree = this.dairyFree,
    diets = null,
    dishTypes = null,
    gaps = null,
    glutenFree = this.glutenFree,
    lowFodmap = this.lowFodmap,
    occasions = null,
    pricePerServing = null,
    sourceName = this.sourceName,
    sourceUrl = this.sourceUrl,
    spoonacularScore = null,
    spoonacularSourceUrl = null,
    license = null,
    nutritionModel = null,
    sustainable = null
    )

/*fun LocalRecipeResponse.toModel(): RecipeModel
    = RecipeModel(
      resultModels = listOf(
          ResultModel(
              id = this.id,
              cookingMinutes = this.cookingMinutes,
              title = this.title,
              image = this.image,
              imageType = this.imageType,
              summary = this.summary,
              servings = this.servings,
              readyInMinutes = this.readyInMinutes,
              preparationMinutes = this.preparationMinutes,
              healthScore = this.healthScore,
              vegan = this.vegan,
              vegetarian = this.vegetarian,
              veryHealthy = this.veryHealthy,
              veryPopular = this.veryPopular,
              cheap = null,
              creditsText = null,
              cuisines = null,
              dairyFree = this.dairyFree,
              diets = null,
              dishTypes = null,
              gaps = null,
              glutenFree = this.glutenFree,
              lowFodmap = this.lowFodmap,
              occasions = null,
              pricePerServing = null,
              sourceName = this.sourceName,
              sourceUrl = this.sourceUrl,
              spoonacularScore = null,
              spoonacularSourceUrl = null,
              license = null,
              nutritionModel = null,
              sustainable = null
          )
      )
    ) */

fun Result.toResultModel(): ResultModel =
    ResultModel(
        cheap = this.cheap,
        cookingMinutes = this.cookingMinutes,
        creditsText = this.creditsText,
        cuisines = this.cuisines,
        dairyFree = this.dairyFree,
        diets = this.diets,
        dishTypes = this.dishTypes,
        gaps = this.gaps,
        glutenFree = this.glutenFree,
        healthScore = this.healthScore,
        id = this.id,
        image = this.image,
        imageType = this.imageType,
        license = this.license,
        lowFodmap = this.lowFodmap,
        occasions = this.occasions,
        preparationMinutes = this.preparationMinutes,
        pricePerServing = this.pricePerServing,
        readyInMinutes = this.readyInMinutes,
        servings = this.servings,
        sourceName = this.sourceName,
        sourceUrl = this.sourceUrl,
        spoonacularScore = this.spoonacularScore,
        spoonacularSourceUrl = this.spoonacularSourceUrl,
        summary = this.summary,
        sustainable = this.sustainable,
        title = this.title,
        vegan = this.vegan,
        vegetarian = this.vegetarian,
        veryHealthy = this.veryHealthy,
        veryPopular = this.veryPopular,
        nutritionModel = this.nutrition.toNutritionModel()
    )

fun Nutrition.toNutritionModel(): NutritionModel
    = NutritionModel(
        ingredientModels = this.ingredients.map { it.toIngredientModel() },
        nutrients = this.nutrients.map { it.toNutrientXModel() }
    )

fun Ingredient.toIngredientModel(): IngredientModel
        = IngredientModel(
    amount = this.amount,
    id = this.id,
    name = this.name,
    unit = this.unit,
    nutrients = this.nutrients.map { it.toNutrientXModel() }
)

fun NutrientX.toNutrientXModel(): NutrientXModel
    = NutrientXModel(
        amount = this.amount,
        name = this.name,
        unit = this.unit,
        percentOfDailyNeeds = this.percentOfDailyNeeds
    )



