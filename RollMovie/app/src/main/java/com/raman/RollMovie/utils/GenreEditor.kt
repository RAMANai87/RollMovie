package com.raman.RollMovie.utils

import com.raman.RollMovie.model.data.detail.movie.Genre
import java.lang.StringBuilder

fun genreEditor(data :Array<Genre>) :String{

    val genre = StringBuilder()

    data.forEach {
        genre.append(" ${it.name},")
    }

    return genre.toString()
}