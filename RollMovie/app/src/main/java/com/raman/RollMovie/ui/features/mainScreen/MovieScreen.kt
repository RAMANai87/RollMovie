package com.raman.RollMovie.ui.features.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.raman.RollMovie.ui.adapters.MinimalLazyRow
import com.raman.RollMovie.ui.adapters.SliderImagesView
import com.raman.RollMovie.ui.component.FlatLazyItem
import com.raman.RollMovie.viewmodel.app.AppViewModel

@Composable

fun MovieScreen(appViewModel: AppViewModel, onItemClicked: (id :Int) -> Unit) {

    Column {

        // get data from network
        val dataPopular = appViewModel.popularFlow.collectAsState()
        val dataTopRated = appViewModel.topRatedFlow.collectAsState()
        val dataUpComing = appViewModel.upComingFlow.collectAsState()
        val dataTrending = appViewModel.trendingFlow.collectAsState()
        val dataDiscover = appViewModel.discoverFlow.collectAsState()
        val dataNowPlaying = appViewModel.nowPlayingFlow.collectAsState()

        if (dataPopular.value!!.isNotEmpty()) {
            if (dataDiscover.value!!.isNotEmpty()) {
                if (dataNowPlaying.value!!.isNotEmpty()) {
                    if (dataTrending.value!!.isNotEmpty()) {
                        if (dataTopRated.value!!.isNotEmpty()) {
                            if (dataUpComing.value!!.isNotEmpty()) {
                                // set data and show them
                                SliderImagesView(titleText = "Popular Movie", data = dataPopular.value!!) {
                                    onItemClicked.invoke(it)
                                }

                                MinimalLazyRow(titleText = "TopRated Movie", data = dataTopRated.value!!) {
                                    onItemClicked.invoke(it)
                                }

                                MinimalLazyRow(titleText = "NowPlaying Movie", data = dataNowPlaying.value!!) {
                                    onItemClicked.invoke(it)
                                }

                                FlatLazyItem(data = dataUpComing.value!![13]) {
                                    onItemClicked.invoke(it)
                                }

                                FlatLazyItem(data = dataUpComing.value!![15]) {
                                    onItemClicked.invoke(it)
                                }

                                FlatLazyItem(data = dataUpComing.value!![16]) {
                                    onItemClicked.invoke(it)
                                }

                                MinimalLazyRow(titleText = "Discover Movie", data = dataDiscover.value!!) {
                                    onItemClicked.invoke(it)
                                }

                                MinimalLazyRow(titleText = "Trending Movie", data = dataTrending.value!!) {
                                    onItemClicked.invoke(it)
                                }

                                FlatLazyItem(data = dataTrending.value!![16]) {
                                    onItemClicked.invoke(it)
                                }

                                FlatLazyItem(data = dataTrending.value!![14]) {
                                    onItemClicked.invoke(it)
                                }

                                MinimalLazyRow(titleText = "UpComing Movie", data = dataUpComing.value!!) {
                                    onItemClicked.invoke(it)
                                }
                            }
                        }
                    }
                }
            }
        }

    }

}