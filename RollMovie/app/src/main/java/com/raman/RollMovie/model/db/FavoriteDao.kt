package com.raman.RollMovie.model.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raman.RollMovie.model.data.FavoriteModel

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite_table")
    suspend fun getAllFavoriteMovies() :List<FavoriteModel>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteMovie(data :FavoriteModel)
    @Delete
    suspend fun deleteFavoriteMovie(data: FavoriteModel)
    @Query("SELECT * FROM favorite_table WHERE id = :id")
    suspend fun searchMovie(id :Int) :FavoriteModel?

}