package com.raman.RollMovie.model.data.detail

data class NetworkCast(
    val id: Int,

    val name: String,

    val adult: Boolean,

    val castId: Int?,

    val character: String,

    val creditId: String,

    val gender: Int?,

    val knownForDepartment: String,

    val order: Int,

    val originalName: String,

    val popularity: Double,

    val profilePath: String?
)