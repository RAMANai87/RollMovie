package com.raman.RollMovie.ui.features.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.raman.RollMovie.ui.adapters.MinimalLazyRow
import com.raman.RollMovie.ui.adapters.SliderImagesView
import com.raman.RollMovie.ui.component.FlatLazyItem
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

        if (dataPopular.value!!.isNotEmpty()) {
            if (dataDiscover.value!!.isNotEmpty()) {
                if (dataOnTheAir.value!!.isNotEmpty()) {
                    if (dataTrending.value!!.isNotEmpty()) {
                        if (dataTopRated.value!!.isNotEmpty()) {

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

                            FlatLazyItem(data = dataTopRated.value!![13]) {
                                onItemClicked.invoke(it)
                            }

                            FlatLazyItem(data = dataTopRated.value!![15]) {
                                onItemClicked.invoke(it)
                            }

                            FlatLazyItem(data = dataTopRated.value!![16]) {
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

                            FlatLazyItem(data = dataTrending.value!![16]) {
                                onItemClicked.invoke(it)
                            }

                            FlatLazyItem(data = dataTrending.value!![14]) {
                                onItemClicked.invoke(it)
                            }

                        }
                    }
                }
            }
        }

    }

}
