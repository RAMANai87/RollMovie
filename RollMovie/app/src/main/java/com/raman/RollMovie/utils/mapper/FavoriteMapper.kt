package com.raman.RollMovie.utils.mapper

import com.raman.RollMovie.model.data.FavoriteModel
import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.model.data.detail.movie.DetailResponse
import com.raman.RollMovie.model.data.detail.tv.TvShowDetail

fun favoriteMapperMovie(data :DetailResponse) :FavoriteModel{
    return FavoriteModel(
        data.id,
        data.original_title,
        data.overview,
        data.poster_path,
        data.vote_average,
        data.release_date,
        data.adult,
        true
    )
}

fun favoriteMapperTvShow(data :TvShowDetail) :FavoriteModel{
    return FavoriteModel(
        data.id,
        data.original_name,
        data.overview,
        data.poster_path,
        data.vote_average,
        data.last_air_date,
        data.adult,
        false
    )
}

fun favoriteMapper(data :List<FavoriteModel>) :List<MovieModel>{
    return data.map {
        MovieModel(
            it.id,
            it.title,
            it.overview,
            it.imageUrl,
            it.vote,
            it.realizeDate,
            it.adult
        )
    }
}