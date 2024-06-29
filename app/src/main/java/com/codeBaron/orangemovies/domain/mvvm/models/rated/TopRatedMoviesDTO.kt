package com.codeBaron.orangemovies.domain.mvvm.models.rated

data class TopRatedMoviesDTO(
    val page: Int,
    val topRatedResults: List<TopRatedResult>,
    val total_pages: Int,
    val total_results: Int
)