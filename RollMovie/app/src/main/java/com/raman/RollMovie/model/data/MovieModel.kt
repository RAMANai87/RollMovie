package com.raman.RollMovie.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("movie_table")
data class MovieModel (
    @PrimaryKey
    val id :Int,
    val title :String,
    val overview :String,
    val imageUrl :String,
    val vote :Double,
    val realizeDate :String,
    val adult :Boolean
)