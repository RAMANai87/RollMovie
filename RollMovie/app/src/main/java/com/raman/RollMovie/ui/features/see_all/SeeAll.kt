package com.raman.RollMovie.ui.features.see_all

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raman.RollMovie.R
import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.ui.adapters.MainLazyColumn
import com.raman.RollMovie.ui.component.detail.UseFulButton
import com.raman.RollMovie.utils.common.AppConstants
import com.raman.RollMovie.utils.common.AppScreens
import com.raman.RollMovie.utils.remote.ApiConstants
import com.raman.RollMovie.viewmodel.app.AppViewModel
import com.raman.RollMovie.viewmodel.favorite.FavoriteViewModel

@Composable
fun SeeAllScreen(
    appViewModel: AppViewModel,
    type: String,
    favoriteViewModel: FavoriteViewModel,
    navController: NavController
) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.White)

    var appBarTitle = "See All"

    var data = remember {
        listOf<MovieModel>()
    }

    var isMovie = true

    when (type) {

        AppConstants.POPULAR_MOVIE -> {
            data = appViewModel.popularFlow.collectAsState().value!!
            appBarTitle = "Popular Movie"
            isMovie = true
        }

        AppConstants.TRENDING_MOVIE -> {
            data = appViewModel.trendingFlow.collectAsState().value!!
            appBarTitle = "Trending Movie"
            isMovie = true
        }

        AppConstants.TOP_RATED_MOVIE -> {
            data = appViewModel.topRatedFlow.collectAsState().value!!
            appBarTitle = "Top Rated Movie"
            isMovie = true
        }

        AppConstants.DISCOVER_MOVIE -> {
            data = appViewModel.discoverFlow.collectAsState().value!!
            appBarTitle = "Discover Movie"
            isMovie = true
        }

        AppConstants.NOW_PLAYING_MOVIE -> {
            data = appViewModel.nowPlayingFlow.collectAsState().value!!
            appBarTitle = "Now Playing Movie"
            isMovie = true
        }

        AppConstants.UP_COMING_MOVIE -> {
            data = appViewModel.upComingFlow.collectAsState().value!!
            appBarTitle = "UpComing Movie"
            isMovie = true
        }

        AppConstants.POPULAR_TV_SHOW -> {
            data = appViewModel.popularFlowTvShow.collectAsState().value!!
            appBarTitle = "Popular Tv Show"
            isMovie = false
        }

        AppConstants.TRENDING_TV_SHOW -> {
            data = appViewModel.trendingFlowTvShow.collectAsState().value!!
            appBarTitle = "Trending Tv Show"
            isMovie = false
        }

        AppConstants.TOP_RATED_TV_SHOW -> {
            data = appViewModel.topRatedFlowTvShow.collectAsState().value!!
            appBarTitle = "Top Rated Tv Show"
            isMovie = false
        }

        AppConstants.ON_THE_AIR_TV_SHOW -> {
            data = appViewModel.onTheAirTvShow.collectAsState().value!!
            appBarTitle = "On the air Tv Show"
            isMovie = false
        }

        AppConstants.DISCOVER_TV_SHOW -> {
            data = appViewModel.discoverFlowTvShow.collectAsState().value!!
            appBarTitle = "Discover Tv Show"
            isMovie = false
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(2.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.width(4.dp))

            UseFulButton(image = R.drawable.ic_arrow_back) {
                navController.popBackStack()
            }

            Text(
                text = appBarTitle,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 30.dp),
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            )

        }

        MainLazyColumn(data = data,
            favoriteViewModel = favoriteViewModel,
            isMovie = isMovie) { id ->
            navController.navigate(AppScreens.DetailScreen.route + "/" + id + "/" + if (isMovie) ApiConstants.MOVIE else ApiConstants.TV_SHOW)
        }

    }

}