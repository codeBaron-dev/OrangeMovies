package com.codeBaron.orangemovies.domain.remote

import com.codeBaron.orangemovies.data.utils.NOW_PLAYING_URL
import com.codeBaron.orangemovies.data.utils.POPULAR_MOVIES_URL
import com.codeBaron.orangemovies.data.utils.TOP_RATED_MOVIES_URL
import com.codeBaron.orangemovies.data.utils.UPCOMING_MOVIES_URL
import com.codeBaron.orangemovies.domain.mvvm.models.playingmovies.PlayingResult
import com.codeBaron.orangemovies.domain.mvvm.models.popular.PopularResult
import com.codeBaron.orangemovies.domain.mvvm.models.rated.TopRatedResult
import com.codeBaron.orangemovies.domain.mvvm.models.upcoming.UpcomingResult
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {

    @GET(POPULAR_MOVIES_URL)
    suspend fun getPopularMovies(): Response<List<PopularResult>>

    @GET(NOW_PLAYING_URL)
    suspend fun getNowPlayingMovies(): Response<List<PlayingResult>>

    @GET(UPCOMING_MOVIES_URL)
    suspend fun getUpcomingMovies(): Response<List<UpcomingResult>>

    @GET(TOP_RATED_MOVIES_URL)
    suspend fun getTopRatedMovies(): Response<List<TopRatedResult>>
}