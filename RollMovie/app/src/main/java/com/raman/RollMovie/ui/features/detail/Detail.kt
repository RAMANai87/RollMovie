package com.raman.RollMovie.ui.features.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raman.RollMovie.R
import com.raman.RollMovie.ui.component.detail.UseFulButton
import com.raman.RollMovie.ui.component.detail.DetailBarMainMovie
import com.raman.RollMovie.ui.component.detail.FavoriteButton
import com.raman.RollMovie.ui.theme.backgroundBottomNav
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.utils.ApiConstants
import com.raman.RollMovie.utils.mapper.detailMapperMovie
import com.raman.RollMovie.utils.mapper.detailMapperTvShow
import com.raman.RollMovie.utils.mapper.favoriteMapperMovie
import com.raman.RollMovie.utils.mapper.favoriteMapperTvShow
import com.raman.RollMovie.viewmodel.app.DetailViewModel
import com.raman.RollMovie.viewmodel.favorite.FavoriteViewModel

@Composable
fun DetailScreen(detailViewModel: DetailViewModel, id: Int, type: String, navController: NavController, favoriteViewModel: FavoriteViewModel) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(backgroundBottomNav)

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.no_internet_anim)
    )

    when (type) {

        ApiConstants.MOVIE -> {

            detailViewModel.getMovieDetail(id)

//                if (detailViewModel.inProgress.value) {
//                    Column(
//                        modifier = Modifier.fillMaxSize()
//                    ) {
//                        LinearProgressIndicator(
//                            color = primaryColor,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(4.dp)
//                        )
//                    }
//                } else if (detailViewModel.hitError.value) {
//
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.SpaceEvenly,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//
//                        Spacer(modifier = Modifier.height(200.dp))
//
//                        LottieAnimation(
//                            composition = composition,
//                            iterations = LottieConstants.IterateForever,
//                            modifier = Modifier.size(240.dp)
//                        )
//
//                        Button(
//                            onClick = { detailViewModel.getMovieDetail(id) },
//                            modifier = Modifier.fillMaxWidth(0.45f),
//                            colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
//                        ) {
//                            Text(
//                                text = "Try Again",
//                                style = TextStyle(
//                                    fontWeight = FontWeight.Bold,
//                                    fontSize = 17.sp
//                                ),
//                                color = Color.White
//                            )
//                        }
//
//                    }
//
//                } else if (!detailViewModel.inProgress.value && !detailViewModel.hitError.value) {

            val detailData = detailViewModel.movieDetail.collectAsState().value!!

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                DetailBarMainMovie(detailMapperMovie(detailData))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp, top = 10.dp)
                        .align(Alignment.TopCenter),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    UseFulButton(R.drawable.ic_arrow_back){
                        navController.popBackStack()
                    }

                    FavoriteButton(color = Color.Red) {isFavorite ->
                        if (isFavorite) {
                            favoriteViewModel.insertData(favoriteMapperMovie(detailData))
                        } else {
                            favoriteViewModel.deleteData(favoriteMapperMovie(detailData))
                        }
                    }

                }

            }

        }

        ApiConstants.TV_SHOW -> {

            detailViewModel.getTvShowDetail(id)

            if (detailViewModel.inProgress.value) {
                LinearProgressIndicator(
                    color = primaryColor,
                    modifier = Modifier.fillMaxWidth()
                )
            } else if (detailViewModel.hitError.value) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(200.dp))

                    LottieAnimation(
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier.size(240.dp)
                    )

                    Button(
                        onClick = { detailViewModel.getTvShowDetail(id) },
                        modifier = Modifier.fillMaxWidth(0.45f),
                        colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
                    ) {
                        Text(
                            text = "Try Again",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 17.sp
                            ),
                            color = Color.White
                        )
                    }

                }

            } else {

                val detailData = detailViewModel.tvShowDetail.collectAsState().value!!

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
                        UseFulButton(R.drawable.ic_arrow_back){
                            navController.popBackStack()
                        }

                        FavoriteButton(color = Color.Red) {isFavorite ->
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