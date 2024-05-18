package com.raman.RollMovie.utils.mapper

import com.raman.RollMovie.model.data.detail.DetailModel
import com.raman.RollMovie.model.data.detail.movie.DetailResponse
import com.raman.RollMovie.model.data.detail.tv.TvShowDetail

fun detailMapperMovie(data :DetailResponse) :DetailModel{
    return DetailModel(
        data.id,
        data.poster_path,
        data.original_title,
        data.vote_average,
        data.runtime,
        data.spoken_languages,
        data.genres,
        data.overview,
        data.release_date,
        data.production_companies
    )
}

fun detailMapperTvShow(data :TvShowDetail) :DetailModel{
    return DetailModel(
        data.id,
        data.poster_path,
        data.original_name,
        data.vote_average,
        data.episode_run_time.lastIndex,
        data.spoken_languages,
        data.genres,
        data.overview,
        data.last_air_date,
        data.production_companies
    )
}