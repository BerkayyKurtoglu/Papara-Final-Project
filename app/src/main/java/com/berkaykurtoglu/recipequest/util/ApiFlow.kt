package com.berkaykurtoglu.recipequest.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


fun<T> apiFlow(
    call : suspend () -> T
) : Flow<SourceResult<T>> = flow {

    try {
        emit(SourceResult.Loading)
        val response = call()
        emit(SourceResult.Success(response))

    }catch (e : Exception){
        emit(SourceResult.Error(e.localizedMessage ?: "An error occurred"))
    }


}.flowOn(Dispatchers.IO)


