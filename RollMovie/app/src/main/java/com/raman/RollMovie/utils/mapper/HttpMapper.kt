package com.raman.RollMovie.utils.mapper

import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.model.data.movie.Result
import com.raman.RollMovie.model.data.tv.ResultTvShow

fun httpMapperMovie(it :Result) :MovieModel {
    return MovieModel(
        it.id,
        it.original_title,
        it.overview,
        it.poster_path,
        it.vote_average,
        it.release_date,
        it.adult
    )
}

fun httpMapperTvShow(it :ResultTvShow) :MovieModel {
    return MovieModel(
        it.id,
        it.original_name,
        it.overview,
        it.poster_path,
        it.vote_average,
        it.first_air_date,
        it.adult
    )
}