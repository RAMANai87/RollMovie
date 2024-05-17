package com.raman.RollMovie.ui.component.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raman.RollMovie.model.data.detail.movie.ProductionCompany

@Composable
fun DetailLazyRow(data :Array<ProductionCompany>) {

    LazyRow(
        modifier = Modifier.padding(top = 8.dp, bottom = 12.dp)
    ) {
        items(count = data.size) {
            DetailLazyRowItem(data = data[it])
        }
    }

}