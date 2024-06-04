package com.raman.RollMovie.utils.common

import com.raman.RollMovie.model.data.detail.movie.Genre
import com.raman.RollMovie.model.data.detail.movie.SpokenLanguage
import java.lang.StringBuilder

fun genreEditor(data :Array<Genre>) :String{

    val genre = StringBuilder()

    data.forEach {
        genre.append(" ${it.name},")
    }

    return genre.toString()
}

fun spokenLangEditor(data :Array<SpokenLanguage>) :String{

    val spokenLang = StringBuilder()

    data.forEach {
        spokenLang.append(" ${it.name},")
    }

    return spokenLang.toString()
}