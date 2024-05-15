package com.raman.RollMovie.ui.features.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.raman.RollMovie.ui.adapters.MinimalLazyRow
import com.raman.RollMovie.ui.adapters.SliderImagesView
import com.raman.RollMovie.ui.component.BigImageItem
import com.raman.RollMovie.viewmodel.app.AppViewModel

@Composable
fun TvShowScreen(appViewModel: AppViewModel, onItemClicked: (id: Int) -> Unit) {

    Column {

        // get data from network
        val dataPopular = appViewModel.popularFlowTvShow.collectAsState()
        val dataTopRated = appViewModel.topRatedFlowTvShow.collectAsState()
        val dataTrending = appViewModel.trendingFlowTvShow.collectAsState()
        val dataDiscover = appViewModel.discoverFlowTvShow.collectAsState()
        val dataOnTheAir = appViewModel.onTheAirTvShow.collectAsState()

        // set data and show them
        SliderImagesView(
            titleText = "Popular Tv Show",
            data = dataPopular.value!!
        ) {
            onItemClicked.invoke(it)
        }

        MinimalLazyRow(
            titleText = "TopRated Tv Show",
            data = dataTopRated.value!!
        ) {
            onItemClicked.invoke(it)
        }

        MinimalLazyRow(
            titleText = "OnTheAir Tv Show",
            data = dataOnTheAir.value!!
        ) {
            onItemClicked.invoke(it)
        }

        BigImageItem(data = dataTopRated.value!![13]) {
            onItemClicked.invoke(it)
        }

        MinimalLazyRow(
            titleText = "Discover Tv Show",
            data = dataDiscover.value!!
        ) {
            onItemClicked.invoke(it)
        }

        MinimalLazyRow(
            titleText = "Trending Tv Show",
            data = dataTrending.value!!
        ) {
            onItemClicked.invoke(it)
        }

        BigImageItem(data = dataTrending.value!![16]) {
            onItemClicked.invoke(it)
        }


    }

}
