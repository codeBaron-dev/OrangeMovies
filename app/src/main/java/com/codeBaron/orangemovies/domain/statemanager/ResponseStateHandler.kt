package com.codeBaron.orangemovies.domain.statemanager

open class ResponseStateHandler<out R> {
    object LoadingState: ResponseStateHandler<Nothing>()
    data class SuccessState<out T>(val data: T): ResponseStateHandler<T>()
    data class ErrorState<out E>(val error: E): ResponseStateHandler<Nothing>()
    data class ErrorMessageState(val message: String): ResponseStateHandler<Nothing>()
}