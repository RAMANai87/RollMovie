package com.raman.RollMovie.utils.mapper

import com.raman.RollMovie.model.data.CreditsModel
import com.raman.RollMovie.model.data.detail.NetworkCast
import com.raman.RollMovie.model.data.detail.NetworkCrew

fun crewMapper(data :List<NetworkCrew>) :List<CreditsModel>{
    return data.map {
        CreditsModel(
            it.profilePath,
            it.name,
            it.job
        )
    }
}

fun castMapper(data :List<NetworkCast>) :List<CreditsModel>{
    return data.map {
        CreditsModel(
            it.profilePath,
            it.name,
            it.character
        )
    }
}