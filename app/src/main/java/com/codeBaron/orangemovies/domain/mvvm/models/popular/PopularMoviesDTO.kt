package com.codeBaron.orangemovies.domain.mvvm.models.popular

data class PopularMoviesDTO(
    val page: Int,
    val popularResults: List<PopularResult>,
    val total_pages: Int,
    val total_results: Int
)