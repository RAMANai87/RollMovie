package com.raman.RollMovie.utils.mapper

import com.raman.RollMovie.model.data.FavoriteModel
import com.raman.RollMovie.model.data.detail.movie.DetailResponse

fun favoriteMapper(data :DetailResponse) :FavoriteModel{
    return FavoriteModel(
        data.id,
        data.original_title,
        data.overview,
        data.poster_path,
        data.vote_average,
        data.release_date,
        data.adult
    )
}