package com.codeBaron.orangemovies.domain.mvvm

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeBaron.orangemovies.domain.mvvm.manager.RepositoriesInterface
import com.codeBaron.orangemovies.domain.mvvm.models.playingmovies.PlayingResult
import com.codeBaron.orangemovies.domain.mvvm.models.popular.PopularResult
import com.codeBaron.orangemovies.domain.mvvm.models.rated.TopRatedResult
import com.codeBaron.orangemovies.domain.mvvm.models.upcoming.UpcomingResult
import com.codeBaron.orangemovies.domain.statemanager.ResponseStateHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repositoriesInterface: RepositoriesInterface) :
    ViewModel() {

    private val _popularMovies = MutableLiveData<ResponseStateHandler<List<PopularResult>?>>()
    val popularMovies: MutableLiveData<ResponseStateHandler<List<PopularResult>?>> = _popularMovies
    private val _topRatedMovies = MutableLiveData<ResponseStateHandler<List<TopRatedResult>?>>()
    val topRatedMovies: MutableLiveData<ResponseStateHandler<List<TopRatedResult>?>> =
        _topRatedMovies
    private val _upcomingMovies = MutableLiveData<ResponseStateHandler<List<UpcomingResult>?>>()
    val upcomingMovies: MutableLiveData<ResponseStateHandler<List<UpcomingResult>?>> =
        _upcomingMovies
    private val _nowPlayingMovies = MutableLiveData<ResponseStateHandler<List<PlayingResult>?>>()
    val nowPlayingMovies: MutableLiveData<ResponseStateHandler<List<PlayingResult>?>> =
        _nowPlayingMovies


    fun getPopularMovies(
        context: Context,
        isDeviceConnectedToInternet: Boolean
    ): LiveData<ResponseStateHandler<List<PopularResult>?>> {
        viewModelScope.launch {
            _popularMovies.value = repositoriesInterface.getPopularMovies(
                context,
                isDeviceConnectedToInternet
            ).value
        }
        return _popularMovies
    }

    fun getTopRatedMovies(
        context: Context,
        isDeviceConnectedToInternet: Boolean
    ): LiveData<ResponseStateHandler<List<TopRatedResult>?>> {
        viewModelScope.launch {
            _topRatedMovies.value = repositoriesInterface.getTopRatedMovies(
                context,
                isDeviceConnectedToInternet
            ).value
        }
        return _topRatedMovies
    }

    fun getUpcomingMovies(
        context: Context,
        isDeviceConnectedToInternet: Boolean
    ): LiveData<ResponseStateHandler<List<UpcomingResult>?>> {
        viewModelScope.launch {
            _upcomingMovies.value = repositoriesInterface.getUpcomingMovies(
                context,
                isDeviceConnectedToInternet
            ).value
        }
        return _upcomingMovies
    }

    fun getNowPlayingMovies(
        context: Context,
        isDeviceConnectedToInternet: Boolean
    ): LiveData<ResponseStateHandler<List<PlayingResult>?>> {
        viewModelScope.launch {
            _nowPlayingMovies.value = repositoriesInterface.getNowPlayingMovies(
                context,
                isDeviceConnectedToInternet
            ).value
        }
        return _nowPlayingMovies
    }
}