package com.raman.RollMovie.model.data

import java.lang.Exception

sealed class HttpResult<out R> {

    data class Success<out R>(val result: R) : HttpResult<R>()
    data class Failure(val exception: Exception): HttpResult<Nothing>()
    data object Loading :HttpResult<Nothing>()

}