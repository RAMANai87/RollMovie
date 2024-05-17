package com.raman.RollMovie.utils

import java.math.RoundingMode
import java.text.DecimalFormat

fun voteEditor(vote :Double) :String {

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    return df.format(vote).toDouble().toString()

}