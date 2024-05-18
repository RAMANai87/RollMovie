package com.raman.RollMovie.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raman.RollMovie.model.data.FavoriteModel
import com.raman.RollMovie.model.data.MovieModel

@Database(entities = [MovieModel::class, FavoriteModel::class], version = 3, exportSchema = false)
abstract class RollMovieDatabase :RoomDatabase(){
    abstract fun movieDao() :MovieDao
    abstract fun favoriteDao() :FavoriteDao
}