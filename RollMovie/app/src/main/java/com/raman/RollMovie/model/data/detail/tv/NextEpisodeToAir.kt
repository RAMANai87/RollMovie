package com.raman.RollMovie.model.data.detail.tv

data class NextEpisodeToAir(
    val air_date: String,
    val episode_number: Int,
    val episode_type: String,
    val id: Int,
    val name: String,
    val overview: String,
    val production_code: String,
    val runtime: Any?,
    val season_number: Int,
    val show_id: Int,
    val still_path: String,
    val vote_average: Int,
    val vote_count: Int
)