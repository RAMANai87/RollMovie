package com.raman.RollMovie.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("favorite_table")
data class FavoriteModel(
    @PrimaryKey
    val id: Int,
    val title: String,
    val overview: String,
    val imageUrl: String?,
    val vote: Double,
    val realizeDate: String,
    val adult: Boolean,
    val isMovie: Boolean
)