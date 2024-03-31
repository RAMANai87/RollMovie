package com.raman.RollMovie.model.data.movie

data class MovieResult(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)