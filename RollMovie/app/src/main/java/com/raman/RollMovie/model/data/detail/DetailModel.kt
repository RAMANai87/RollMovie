package com.raman.RollMovie.model.data.detail

import com.raman.RollMovie.model.data.detail.movie.Genre
import com.raman.RollMovie.model.data.detail.movie.ProductionCompany
import com.raman.RollMovie.model.data.detail.movie.SpokenLanguage

data class DetailModel(
    val image :String,
    val title :String,
    val vote :Double,
    val time :Int,
    val spokenLang :Array<SpokenLanguage>,
    val genre :Array<Genre>,
    val overview :String,
    val realizeDate :String,
    val productionCompany :Array<ProductionCompany>
)