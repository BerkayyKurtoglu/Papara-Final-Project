package com.berkaykurtoglu.recipequest.domain.usecase

import javax.inject.Inject

data class UseCase @Inject constructor(
    val checkNetworkUseCase: CheckNetworkUseCase,
    val getAllRecipesFromCache: GetAllRecipesFromCache,
    val getRecipeByIdFromNetworkUseCase: GetRecipeByIdFromNetworkUseCase,
    val saveRecipeToCacheUseCase: SaveRecipeToCacheUseCase,
    val getCacheCountUseCase: GetCacheCountUseCase,
    val getOldestUseCase : GetOldestRecipeUseCase,
    val deleteRecipeFromCache: DeleteRecipeCacheUseCase,
    val insertRecipeToFavoriteUseCase: InsertRecipeToFavoriteUseCase,
    val deleteRecipeFromFavoriteUseCase: DeleteRecipeFromFavoritesUseCase,
    val getAllFavoritesUseCase: GetAllFavoritesUseCase,
    val getRecipeByIdFromCacheUseCase: GetRecipeByIdFromCacheUseCase,
    val getRecipeByIdFromFavoriteUseCase: GetRecipeByIdFromFavoriteUseCase,
    val searchRecipesFromNetworkUseCase : SearchRecipesFromNetworkUseCase,
    val searchRecipeFromCacheUseCase: SearchRecipeFromCacheUseCase,
    val getAllRecipesFromNetworkUseCase : GetAllRecipesFromNetworkUseCase
)