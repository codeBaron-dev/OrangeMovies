package com.codeBaron.orangemovies.domain.mvvm.manager

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.codeBaron.orangemovies.domain.mvvm.models.playingmovies.PlayingResult
import com.codeBaron.orangemovies.domain.mvvm.models.popular.PopularResult
import com.codeBaron.orangemovies.domain.mvvm.models.rated.TopRatedResult
import com.codeBaron.orangemovies.domain.mvvm.models.upcoming.UpcomingResult
import com.codeBaron.orangemovies.domain.statemanager.ResponseStateHandler

interface RepositoriesInterface {

    suspend fun getPopularMovies(
        context: Context,
        isDeviceConnectedToInternet: Boolean
    ): MutableLiveData<ResponseStateHandler<List<PopularResult>?>>

    suspend fun getTopRatedMovies(
        context: Context,
        isDeviceConnectedToInternet: Boolean
    ): MutableLiveData<ResponseStateHandler<List<TopRatedResult>?>>

    suspend fun getUpcomingMovies(
        context: Context,
        isDeviceConnectedToInternet: Boolean
    ): MutableLiveData<ResponseStateHandler<List<UpcomingResult>?>>

    suspend fun getNowPlayingMovies(
        context: Context,
        isDeviceConnectedToInternet: Boolean
    ): MutableLiveData<ResponseStateHandler<List<PlayingResult>?>>
}