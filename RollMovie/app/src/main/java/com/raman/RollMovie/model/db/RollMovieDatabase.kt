package com.raman.RollMovie.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raman.RollMovie.model.data.MovieModel

@Database(entities = [MovieModel::class], version = 1, exportSchema = false)
abstract class RollMovieDatabase :RoomDatabase(){
    abstract fun movieDao() :MovieDao
    abstract fun favoriteDao() :FavoriteDao
}