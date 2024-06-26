package com.raman.RollMovie.model.data.detail.tv

import com.raman.RollMovie.model.data.detail.NetworkCredits
import com.raman.RollMovie.model.data.detail.movie.Genre
import com.raman.RollMovie.model.data.detail.movie.ProductionCompany
import com.raman.RollMovie.model.data.detail.movie.ProductionCountry
import com.raman.RollMovie.model.data.detail.movie.SpokenLanguage

data class TvShowDetail(
    val adult: Boolean,
    val backdrop_path: String,
    val created_by: Array<Any>,
    val episode_run_time: List<Int>,
    val first_air_date: String,
    val genres: Array<Genre>,
    val credits: NetworkCredits,
    val homepage: String,
    val id: Int,
    val in_production: Boolean,
    val languages: List<String>,
    val last_air_date: String,
    val last_episode_to_air: LastEpisodeToAir,
    val name: String,
    val networks: Array<Network>,
    val next_episode_to_air: NextEpisodeToAir?,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: Array<ProductionCompany>,
    val production_countries: Array<ProductionCountry>,
    val seasons: Array<Season>,
    val spoken_languages: Array<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val type: String,
    val vote_average: Double,
    val vote_count: Int
)