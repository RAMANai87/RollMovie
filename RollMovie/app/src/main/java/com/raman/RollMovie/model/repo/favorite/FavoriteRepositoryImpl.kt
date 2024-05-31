package com.raman.RollMovie.model.repo.favorite

import com.raman.RollMovie.model.data.FavoriteModel
import com.raman.RollMovie.model.db.FavoriteDao
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val favoriteDao: FavoriteDao
) :FavoriteRepository {
    override suspend fun getAllFavoriteMovies() :List<FavoriteModel> {
        return favoriteDao.getAllFavoriteMovies()
    }

    override suspend fun insertFavoriteMovie(data :FavoriteModel) {
        favoriteDao.insertFavoriteMovie(data)
    }

    override suspend fun deleteFavoriteMovie(data: FavoriteModel) {
        favoriteDao.deleteFavoriteMovie(data)
    }

    override suspend fun searchFavoriteMovie(id: Int): Boolean {
        val result = favoriteDao.searchMovie(id)
        return result != null
    }
}