package com.berkaykurtoglu.recipequest.domain.usecase

import com.berkaykurtoglu.recipequest.data.source.remote.dto.searchdto.RecipeSearchDto
import com.berkaykurtoglu.recipequest.domain.repository.HomeRepository
import com.berkaykurtoglu.recipequest.util.SourceResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRecipesFromNetworkUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

    suspend operator fun invoke(
        query: String
    ) : Flow<SourceResult<RecipeSearchDto>> = homeRepository.searchRecipesFromNetwork(query)

}