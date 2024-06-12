package com.berkaykurtoglu.recipequest.domain.usecase

import androidx.paging.PagingData
import com.berkaykurtoglu.recipequest.domain.model.recipesmodel.RecipeModel
import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllRecipesFromNetworkUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

    suspend operator fun invoke(
        type : String
    ) : Flow<PagingData<RecipeModel>> =
        homeRepository.getAllRecipesNetwork(
            type
        )


}