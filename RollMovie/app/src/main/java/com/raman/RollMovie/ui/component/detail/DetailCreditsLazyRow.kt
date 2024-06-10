package com.raman.RollMovie.ui.component.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raman.RollMovie.model.data.CreditsModel
import com.raman.RollMovie.model.data.detail.movie.ProductionCompany

@Composable
fun DetailCreditsLazyRow(data :List<CreditsModel>) {

    LazyRow(
        modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)
    ) {
        items(count = data.size) {
            DetailCreditsLazyRowItem(data = data[it])
        }
    }

}