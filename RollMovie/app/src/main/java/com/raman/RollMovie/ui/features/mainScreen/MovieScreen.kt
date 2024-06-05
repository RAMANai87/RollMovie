package com.raman.RollMovie.ui.features.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.raman.RollMovie.ui.adapters.MinimalLazyRow
import com.raman.RollMovie.ui.adapters.SliderImagesView
import com.raman.RollMovie.ui.component.BigImageItem
import com.raman.RollMovie.utils.common.AppConstants
import com.raman.RollMovie.viewmodel.app.AppViewModel

@Composable
fun MovieScreen(appViewModel: AppViewModel, onSeeAllClicked :(String) -> Unit,onItemClicked: (id: Int) -> Unit) {

    Column {

        // get data from network
        val dataPopular = appViewModel.popularFlow.collectAsState()
        val dataTopRated = appViewModel.topRatedFlow.collectAsState()
        val dataUpComing = appViewModel.upComingFlow.collectAsState()
        val dataTrending = appViewModel.trendingFlow.collectAsState()
        val dataDiscover = appViewModel.discoverFlow.collectAsState()
        val dataNowPlaying = appViewModel.nowPlayingFlow.collectAsState()

        // set data and show them
        SliderImagesView(titleText = "Popular Movie", data = dataPopular.value!!, onSeeAllClicked = {onSeeAllClicked.invoke(AppConstants.POPULAR_MOVIE)}) {
            onItemClicked.invoke(it)
        }

        MinimalLazyRow(titleText = "TopRated Movie", data = dataTopRated.value!!, {onSeeAllClicked.invoke(AppConstants.TOP_RATED_MOVIE)}) {
            onItemClicked.invoke(it)
        }

        MinimalLazyRow(titleText = "NowPlaying Movie", data = dataNowPlaying.value!!, {onSeeAllClicked.invoke(AppConstants.NOW_PLAYING_MOVIE)}) {
            onItemClicked.invoke(it)
        }

        BigImageItem(data = dataUpComing.value!![13]) {
            onItemClicked.invoke(it)
        }

        MinimalLazyRow(titleText = "Discover Movie", data = dataDiscover.value!!, {onSeeAllClicked.invoke(AppConstants.DISCOVER_MOVIE)}) {
            onItemClicked.invoke(it)
        }

        MinimalLazyRow(titleText = "Trending Movie", data = dataTrending.value!!, {onSeeAllClicked.invoke(AppConstants.TRENDING_MOVIE)}) {
            onItemClicked.invoke(it)
        }

        BigImageItem(data = dataTrending.value!![16]) {
            onItemClicked.invoke(it)
        }

        MinimalLazyRow(titleText = "UpComing Movie", data = dataUpComing.value!!, {onSeeAllClicked.invoke(AppConstants.UP_COMING_MOVIE)}) {
            onItemClicked.invoke(it)
        }

        BigImageItem(data = dataTrending.value!![14]) {
            onItemClicked.invoke(it)
        }

    }

}