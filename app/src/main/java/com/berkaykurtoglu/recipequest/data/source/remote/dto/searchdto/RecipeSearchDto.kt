package com.berkaykurtoglu.recipequest.data.source.remote.dto.searchdto


import com.berkaykurtoglu.recipequest.domain.model.recipesearchmodel.RecipeSearchModel
import com.google.gson.annotations.SerializedName

class RecipeSearchDto : ArrayList<RecipeSearchDtoItem>(){

    fun toRecipeSearchModelList() : List<RecipeSearchModel> =
        this.map {
            RecipeSearchModel(
                id = it.id,
                title = it.title
            )
        }


}