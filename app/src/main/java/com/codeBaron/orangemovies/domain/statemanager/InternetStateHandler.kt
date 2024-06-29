package com.codeBaron.orangemovies.domain.statemanager

open class InternetStateHandler<out R> {
    data class IsInternetAvailable<out T>(val isAvailable: Boolean) : InternetStateHandler<T>()

    data class IsInternetConnectionTypeChanged<out T>(val isChanged: Boolean) : InternetStateHandler<T>()

    data class IsInternetConnectionLost<out T>(val isLost: Boolean) : InternetStateHandler<T>()
}