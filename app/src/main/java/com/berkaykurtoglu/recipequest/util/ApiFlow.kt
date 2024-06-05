package com.berkaykurtoglu.recipequest.util

import coil.network.HttpException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import retrofit2.Response


fun<T> apiFlow(
    call : suspend () -> Response<T>
) : Flow<ApiResult<T>> = flow {

    try {
        emit(ApiResult.Loading)
        val response = call()
        if (response.isSuccessful){
            response.body()?.let {
                emit(ApiResult.Success(it))
            }
        }else{
            emit(ApiResult.Error(response.message()))
        }

    }catch (e : HttpException){
        emit(ApiResult.Error(e.localizedMessage ?: "Unexpected Error"))
    }catch (e : IOException){
        emit(ApiResult.Error(e.localizedMessage ?: "Unexpected Error"))
    }


}.flowOn(Dispatchers.IO)


