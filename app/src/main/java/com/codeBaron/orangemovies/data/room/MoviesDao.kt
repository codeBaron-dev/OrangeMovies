package com.codeBaron.orangemovies.data.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codeBaron.orangemovies.domain.mvvm.models.playingmovies.PlayingResult
import com.codeBaron.orangemovies.domain.mvvm.models.popular.PopularResult
import com.codeBaron.orangemovies.domain.mvvm.models.rated.TopRatedResult
import com.codeBaron.orangemovies.domain.mvvm.models.upcoming.UpcomingResult

interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovies(popularMoviesDTO: List<PopularResult>?)

    @Query("SELECT * FROM popular_movies_table")
    fun getPopularMovies(): List<PopularResult>

    @Query("DELETE FROM popular_movies_table")
    fun deletePopularMovies()

    @Query("SELECT * FROM popular_movies_table WHERE id = :id")
    fun getPopularMovieById(id: Int): PopularResult

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNowPlayingMovies(nowPlayingMoviesDTO: List<PlayingResult>?)

    @Query("SELECT * FROM now_playing_table")
    fun getNowPlayingMovies(): List<PlayingResult>

    @Query("DELETE FROM now_playing_table")
    fun deleteNowPlayingMovies()

    @Query("SELECT * FROM now_playing_table WHERE id = :id")
    fun getNowPlayingMovieById(id: Int): PlayingResult

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopRatedMovies(topRatedMoviesDTO: List<TopRatedResult>?)

    @Query("SELECT * FROM top_rated_movies_table")
    fun getTopRatedMovies(): List<TopRatedResult>

    @Query("DELETE FROM top_rated_movies_table")
    fun deleteTopRatedMovies()

    @Query("SELECT * FROM top_rated_movies_table WHERE id = :id")
    fun getTopRatedMovieById(id: Int): TopRatedResult

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpcomingMovies(upcomingMoviesDTO: List<UpcomingResult>?)

    @Query("SELECT * FROM upcoming_movies_table")
    fun getUpcomingMovies(): List<UpcomingResult>

    @Query("DELETE FROM upcoming_movies_table")
    fun deleteUpcomingMovies()

    @Query("SELECT * FROM upcoming_movies_table WHERE id = :id")
    fun getUpcomingMovieById(id: Int): UpcomingResult
}