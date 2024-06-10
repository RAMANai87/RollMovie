package com.raman.RollMovie.ui.features.detail

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raman.RollMovie.R
import com.raman.RollMovie.ui.component.detail.UseFulButton
import com.raman.RollMovie.ui.component.detail.DetailBarMainMovie
import com.raman.RollMovie.ui.component.detail.FavoriteButton
import com.raman.RollMovie.ui.theme.backgroundBottomNav
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.utils.remote.ApiConstants
import com.raman.RollMovie.utils.mapper.detailMapperMovie
import com.raman.RollMovie.utils.mapper.detailMapperTvShow
import com.raman.RollMovie.utils.mapper.favoriteMapperMovie
import com.raman.RollMovie.utils.mapper.favoriteMapperTvShow
import com.raman.RollMovie.viewmodel.app.DetailViewModel
import com.raman.RollMovie.viewmodel.favorite.FavoriteViewModel

@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel,
    id: Int,
    type: String,
    navController: NavController,
    favoriteViewModel: FavoriteViewModel
) {

    BackHandler {
        navController.popBackStack()
        detailViewModel.deleteDataForBackPressed()
    }
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(backgroundBottomNav)

    when (type) {

        ApiConstants.MOVIE -> {

            detailViewModel.getMovieDetail(id)
            val detailData = detailViewModel.movieDetail.collectAsState().value

            if (detailData == null) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    CircularProgressIndicator(
                        color = primaryColor,
                        modifier = Modifier.padding(100.dp)
                    )
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    DetailBarMainMovie(
                        detailMapperMovie(detailData),
                        Modifier
                            .fillMaxSize()
                            .background(backgroundBottomNav)
                            .verticalScroll(rememberScrollState())
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp, top = 10.dp)
                            .align(Alignment.TopCenter),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        UseFulButton(R.drawable.ic_arrow_back) {
                            navController.popBackStack()
                            detailViewModel.deleteDataForBackPressed()
                        }

                        FavoriteButton(
                            color = Color.Red,
                            favoriteViewModel = favoriteViewModel,
                            id = id
                        ) { isFavorite ->
                            if (isFavorite) {
                                favoriteViewModel.insertData(favoriteMapperMovie(detailData))
                            } else {
                                favoriteViewModel.deleteData(favoriteMapperMovie(detailData))
                            }
                        }

                    }

                }
            }

        }

        ApiConstants.TV_SHOW -> {

            detailViewModel.getTvShowDetail(id)
            val detailData = detailViewModel.tvShowDetail.collectAsState().value

            if (detailData == null) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        color = primaryColor,
                        modifier = Modifier.padding(100.dp)
                    )
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    DetailBarMainMovie(detailMapperTvShow(detailData))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp, top = 10.dp)
                            .align(Alignment.TopCenter),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        UseFulButton(R.drawable.ic_arrow_back) {
                            navController.popBackStack()
                            detailViewModel.deleteDataForBackPressed()
                        }

                        FavoriteButton(
                            color = Color.Red,
                            favoriteViewModel = favoriteViewModel,
                            id = id
                        ) { isFavorite ->
                            if (isFavorite) {
                                favoriteViewModel.insertData(favoriteMapperTvShow(detailData))
                            } else {
                                favoriteViewModel.deleteData(favoriteMapperTvShow(detailData))
                            }
                        }

                    }

                }
            }

        }

    }

}