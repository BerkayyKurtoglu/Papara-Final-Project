package com.berkaykurtoglu.recipequest.util

sealed class ApiResult<out T> {

    data class Success<out R>(val data : R) : ApiResult<R>()
    data object Loading : ApiResult<Nothing>()
    data class Error(val message : String) : ApiResult<Nothing>()

}


