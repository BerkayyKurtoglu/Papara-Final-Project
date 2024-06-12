package com.berkaykurtoglu.recipequest.domain.usecase

import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.domain.repository.FavoriteScreenRepository
import com.berkaykurtoglu.recipequest.util.SourceResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFavoritesUseCase @Inject constructor(
    private val favoriteScreenRepository: FavoriteScreenRepository
) {

    suspend operator fun invoke() : Flow<SourceResult<List<RecipeDetailEntity>>> =
        favoriteScreenRepository.getAllFavoriteRecipes()

}