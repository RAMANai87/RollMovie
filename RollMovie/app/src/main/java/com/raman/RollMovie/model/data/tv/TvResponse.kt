package com.raman.RollMovie.model.data.tv

data class TvResponse(
    val page: Int,
    val results: List<ResultTvShow>,
    val total_pages: Int,
    val total_results: Int
)