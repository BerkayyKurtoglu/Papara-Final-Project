package com.berkaykurtoglu.recipequest.util

import coil.network.HttpException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import retrofit2.Response


fun<T> apiFlow(
    call : suspend () -> T
) : Flow<ApiResult<T>> = flow {

    try {
        emit(ApiResult.Loading)
        val response = call()
        emit(ApiResult.Success(response))

    }catch (e : Exception){
        emit(ApiResult.Error(e.localizedMessage ?: "An error occurred"))
    }


}.flowOn(Dispatchers.IO)


