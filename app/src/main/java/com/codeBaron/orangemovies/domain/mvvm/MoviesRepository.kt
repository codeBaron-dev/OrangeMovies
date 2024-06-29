package com.codeBaron.orangemovies.domain.mvvm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.codeBaron.orangemovies.data.room.MoviesDatabase
import com.codeBaron.orangemovies.domain.ErrorResponseManager.ErrorMapper
import com.codeBaron.orangemovies.domain.mvvm.manager.RepositoriesInterface
import com.codeBaron.orangemovies.domain.mvvm.models.playingmovies.PlayingResult
import com.codeBaron.orangemovies.domain.mvvm.models.popular.PopularResult
import com.codeBaron.orangemovies.domain.mvvm.models.rated.TopRatedResult
import com.codeBaron.orangemovies.domain.mvvm.models.upcoming.UpcomingResult
import com.codeBaron.orangemovies.domain.remote.MoviesApi
import com.codeBaron.orangemovies.domain.statemanager.ResponseStateHandler

class MoviesRepository(private val moviesApi: MoviesApi) : RepositoriesInterface {

    private var errorMapper: ErrorMapper = ErrorMapper()
    private var popularMovies: List<PopularResult>? = null
    private var topRatedMovies: List<TopRatedResult>? = null
    private var upcomingMovies: List<UpcomingResult>? = null
    private var nowPlayingMovies: List<PlayingResult>? = null


    override suspend fun getPopularMovies(
        context: Context, isDeviceConnectedToInternet: Boolean
    ): MutableLiveData<ResponseStateHandler<List<PopularResult>?>> {
        val responseStateHandler: MutableLiveData<ResponseStateHandler<List<PopularResult>?>> =
            MutableLiveData()
        val request = moviesApi.getPopularMovies()
        responseStateHandler.postValue(ResponseStateHandler.LoadingState)
        val localDatabase = MoviesDatabase(context = context)
        try {
            if (!isDeviceConnectedToInternet) {
                if (localDatabase.MoviesDao().getPopularMovies().isNotEmpty()) {
                    popularMovies = localDatabase.MoviesDao().getPopularMovies()
                    responseStateHandler.postValue(ResponseStateHandler.SuccessState(popularMovies))
                } else {
                    responseStateHandler.postValue(ResponseStateHandler.ErrorState("No Internet"))
                }
            } else {
                if (localDatabase.MoviesDao().getPopularMovies().isEmpty()) {
                    if (request.isSuccessful) {
                        popularMovies = request.body()
                        localDatabase.MoviesDao().insertPopularMovies(popularMovies)
                        responseStateHandler.postValue(
                            ResponseStateHandler.SuccessState(
                                popularMovies
                            )
                        )
                    } else {
                        val errorResponse = errorMapper.parseErrorMessage(request.errorBody())
                        responseStateHandler.postValue(ResponseStateHandler.ErrorState(errorResponse))
                    }
                } else {
                    popularMovies = localDatabase.MoviesDao().getPopularMovies()
                    responseStateHandler.postValue(ResponseStateHandler.SuccessState(popularMovies))
                }
            }
        } catch (e: Exception) {
            responseStateHandler.postValue(ResponseStateHandler.ErrorState(e))
        }

        return responseStateHandler
    }

    override suspend fun getTopRatedMovies(
        context: Context, isDeviceConnectedToInternet: Boolean
    ): MutableLiveData<ResponseStateHandler<List<TopRatedResult>?>> {
        val responseStateHandler: MutableLiveData<ResponseStateHandler<List<TopRatedResult>?>> =
            MutableLiveData()
        val request = moviesApi.getTopRatedMovies()
        responseStateHandler.postValue(ResponseStateHandler.LoadingState)
        val localDatabase = MoviesDatabase(context = context)
        try {
            if (!isDeviceConnectedToInternet) {
                if (localDatabase.MoviesDao().getTopRatedMovies().isNotEmpty()) {
                    topRatedMovies = localDatabase.MoviesDao().getTopRatedMovies()
                    responseStateHandler.postValue(ResponseStateHandler.SuccessState(topRatedMovies))
                } else {
                    responseStateHandler.postValue(ResponseStateHandler.ErrorState("No Internet"))
                }
            } else {
                if (localDatabase.MoviesDao().getTopRatedMovies().isEmpty()) {
                    if (request.isSuccessful) {
                        topRatedMovies = request.body()
                        localDatabase.MoviesDao().insertTopRatedMovies(topRatedMovies)
                        responseStateHandler.postValue(
                            ResponseStateHandler.SuccessState(
                                topRatedMovies
                            )
                        )
                    } else {
                        val errorResponse = errorMapper.parseErrorMessage(request.errorBody())
                        responseStateHandler.postValue(ResponseStateHandler.ErrorState(errorResponse))
                    }
                } else {
                    topRatedMovies = localDatabase.MoviesDao().getTopRatedMovies()
                    responseStateHandler.postValue(ResponseStateHandler.SuccessState(topRatedMovies))
                }
            }
        } catch (e: Exception) {
            responseStateHandler.postValue(ResponseStateHandler.ErrorState(e))
        }

        return responseStateHandler
    }

    override suspend fun getUpcomingMovies(
        context: Context, isDeviceConnectedToInternet: Boolean
    ): MutableLiveData<ResponseStateHandler<List<UpcomingResult>?>> {
        val responseStateHandler: MutableLiveData<ResponseStateHandler<List<UpcomingResult>?>> =
            MutableLiveData()
        val request = moviesApi.getUpcomingMovies()
        responseStateHandler.postValue(ResponseStateHandler.LoadingState)
        val localDatabase = MoviesDatabase(context = context)
        try {
            if (!isDeviceConnectedToInternet) {
                if (localDatabase.MoviesDao().getUpcomingMovies().isNotEmpty()) {
                    upcomingMovies = localDatabase.MoviesDao().getUpcomingMovies()
                    responseStateHandler.postValue(ResponseStateHandler.SuccessState(upcomingMovies))
                } else {
                    responseStateHandler.postValue(ResponseStateHandler.ErrorState("No Internet"))
                }
            } else {
                if (localDatabase.MoviesDao().getUpcomingMovies().isEmpty()) {
                    if (request.isSuccessful) {
                        upcomingMovies = request.body()
                        localDatabase.MoviesDao().insertUpcomingMovies(upcomingMovies)
                        responseStateHandler.postValue(
                            ResponseStateHandler.SuccessState(
                                upcomingMovies
                            )
                        )
                    } else {
                        val errorResponse = errorMapper.parseErrorMessage(request.errorBody())
                        responseStateHandler.postValue(ResponseStateHandler.ErrorState(errorResponse))
                    }
                } else {
                    upcomingMovies = localDatabase.MoviesDao().getUpcomingMovies()
                    responseStateHandler.postValue(ResponseStateHandler.SuccessState(upcomingMovies))
                }
            }
        } catch (e: Exception) {
            responseStateHandler.postValue(ResponseStateHandler.ErrorState(e))
        }

        return responseStateHandler
    }

    override suspend fun getNowPlayingMovies(
        context: Context, isDeviceConnectedToInternet: Boolean
    ): MutableLiveData<ResponseStateHandler<List<PlayingResult>?>> {
        val responseStateHandler: MutableLiveData<ResponseStateHandler<List<PlayingResult>?>> =
            MutableLiveData()
        val request = moviesApi.getNowPlayingMovies()
        responseStateHandler.postValue(ResponseStateHandler.LoadingState)
        val localDatabase = MoviesDatabase(context = context)
        try {
            if (!isDeviceConnectedToInternet) {
                if (localDatabase.MoviesDao().getNowPlayingMovies().isNotEmpty()) {
                    nowPlayingMovies = localDatabase.MoviesDao().getNowPlayingMovies()
                    responseStateHandler.postValue(
                        ResponseStateHandler.SuccessState(
                            nowPlayingMovies
                        )
                    )
                } else {
                    responseStateHandler.postValue(ResponseStateHandler.ErrorState("No Internet"))
                }
            } else {
                if (localDatabase.MoviesDao().getNowPlayingMovies().isEmpty()) {
                    if (request.isSuccessful) {
                        nowPlayingMovies = request.body()
                        localDatabase.MoviesDao().insertNowPlayingMovies(nowPlayingMovies)
                        responseStateHandler.postValue(
                            ResponseStateHandler.SuccessState(
                                nowPlayingMovies
                            )
                        )
                    } else {
                        val errorResponse = errorMapper.parseErrorMessage(request.errorBody())
                        responseStateHandler.postValue(ResponseStateHandler.ErrorState(errorResponse))
                    }
                } else {
                    nowPlayingMovies = localDatabase.MoviesDao().getNowPlayingMovies()
                    responseStateHandler.postValue(
                        ResponseStateHandler.SuccessState(
                            nowPlayingMovies
                        )
                    )
                }
            }
        } catch (e: Exception) {
            responseStateHandler.postValue(ResponseStateHandler.ErrorState(e))
        }

        return responseStateHandler
    }
}