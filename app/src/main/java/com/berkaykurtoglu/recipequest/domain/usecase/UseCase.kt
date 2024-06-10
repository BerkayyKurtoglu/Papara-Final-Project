package com.berkaykurtoglu.recipequest.domain.usecase

data class UseCase(
    val checkNetworkUseCase: CheckNetworkUseCase,
    val getAllRecipesRandomlyUseCase: GetAllRecipesRandomlyUseCase,
    val getAllRecipesFromLocalUseCase: GetAllRecipesFromLocalUseCase,
    val deleteAllCacheUseCase: DeleteAllCacheUseCase,
    val insertCacheUseCase: InsertCacheUseCase,
    val getRecipeByIdFromNetworkUseCase: GetRecipeByIdFromNetworkUseCase,
    val saveRecipeToCache: SaveRecipeToCache,
    val getCacheCountUseCase: GetCacheCountUseCase,
    val getOldestUseCase : GetOldestRecipeUseCase,
    val deleteRecipeFromCache: DeleteRecipeCacheUseCase
)