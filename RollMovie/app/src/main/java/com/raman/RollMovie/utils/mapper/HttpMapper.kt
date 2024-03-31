package com.raman.RollMovie.utils.mapper

import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.model.data.movie.Result

fun httpMapper(it :Result) :MovieModel {
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