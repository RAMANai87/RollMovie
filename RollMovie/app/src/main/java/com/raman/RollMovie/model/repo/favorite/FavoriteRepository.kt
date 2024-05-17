package com.raman.RollMovie.model.repo.favorite

import com.raman.RollMovie.model.data.FavoriteModel

interface FavoriteRepository {

    suspend fun getAllFavoriteMovies() :List<FavoriteModel>
    suspend fun insertFavoriteMovie(data :FavoriteModel)
    suspend fun deleteFavoriteMovie(data :FavoriteModel)

}