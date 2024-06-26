package com.raman.RollMovie.ui.adapters

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.ui.component.lazyItem.MainLazyItem
import com.raman.RollMovie.utils.mapper.favoriteMapperSearchMovie
import com.raman.RollMovie.utils.mapper.favoriteMapperSearchTvShow
import com.raman.RollMovie.viewmodel.favorite.FavoriteViewModel

@Composable
fun MainLazyColumn(
    data: List<MovieModel>,
    favoriteViewModel: FavoriteViewModel,
    isMovie: Boolean,
    modifier: Modifier = Modifier,
    onItemClicked: (id: Int) -> Unit
) {

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(bottom = 6.dp)
    ) {

        items(data.size) {
            MainLazyItem(data = data[it], isFavoriteMovie = { isFavoriteMovie ->
                if (isFavoriteMovie) {
                    favoriteViewModel.insertData(
                        if (isMovie) favoriteMapperSearchMovie(data[it]) else favoriteMapperSearchTvShow(
                            data[it]
                        )
                    )
                } else {
                    favoriteViewModel.deleteData(
                        if (isMovie) favoriteMapperSearchMovie(data[it]) else favoriteMapperSearchTvShow(
                            data[it]
                        )
                    )
                }
            }, onItemClick = { id ->
                onItemClicked.invoke(id)
            })
        }

    }

}