package com.berkaykurtoglu.recipequest.util

sealed class SourceResult<out T> {

    data class Success<out R>(val data : R) : SourceResult<R>()
    data object Loading : SourceResult<Nothing>()
    data class Error(val message : String) : SourceResult<Nothing>()

}


