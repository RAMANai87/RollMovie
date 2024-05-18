package com.raman.RollMovie.ui.adapters

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raman.RollMovie.model.data.detail.DetailModel
import com.raman.RollMovie.ui.component.MainLazyItem

@Composable
fun MainLazyColumn(data: List<DetailModel>, isFavorite :(Boolean) -> Unit, onItemClicked :(id :Int) -> Unit) {

    LazyColumn(
        modifier = Modifier.padding(top = 12.dp, start = 6.dp, end = 6.dp)
    ) {

        items(data.size) {
            MainLazyItem(data = data[it], isFavoriteMovie = {isFavoriteMovie ->
                isFavorite.invoke(isFavoriteMovie)
            }, onItemClick = {id ->
                onItemClicked.invoke(id)
            })
        }

    }

}