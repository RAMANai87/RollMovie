package com.raman.RollMovie.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raman.RollMovie.model.data.MovieModel

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies( data :List<MovieModel> )

    @Query("SELECT * FROM movie_table ")
    suspend fun getAll() :List<MovieModel>

}