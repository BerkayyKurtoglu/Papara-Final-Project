package com.berkaykurtoglu.recipequest.domain.usecase

data class UseCase(
    val checkNetworkUseCase: CheckNetworkUseCase,
    val getAllRecipesRandomlyUseCase: GetAllRecipesRandomlyUseCase
)