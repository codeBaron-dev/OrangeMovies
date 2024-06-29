package com.codeBaron.orangemovies.domain.mvvm.models.upcoming

data class UpcomingMoviesDTO(
    val dates: Dates,
    val page: Int,
    val upcomingResults: List<UpcomingResult>,
    val total_pages: Int,
    val total_results: Int
)