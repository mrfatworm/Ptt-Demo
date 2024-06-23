package com.mrfatworm.pttdemo.data

sealed class PttResult<out R> {
    data class Success<out T>(val data: T) : PttResult<T>()
    data class Error(val exception: Exception) : PttResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}