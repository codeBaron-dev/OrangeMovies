package com.codeBaron.orangemovies.domain.mvvm.models.playingmovies

data class NowPlayingMoviesDTO(
    val dates: Dates,
    val page: Int,
    val playingResults: List<PlayingResult>,
    val total_pages: Int,
    val total_results: Int
)