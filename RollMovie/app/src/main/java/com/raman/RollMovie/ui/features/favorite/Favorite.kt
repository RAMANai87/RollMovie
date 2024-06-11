package com.raman.RollMovie.ui.features.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raman.RollMovie.R
import com.raman.RollMovie.ui.component.lazyItem.MinimalLazyItem
import com.raman.RollMovie.ui.component.detail.UseFulButton
import com.raman.RollMovie.utils.remote.ApiConstants
import com.raman.RollMovie.utils.common.AppScreens
import com.raman.RollMovie.utils.mapper.favoriteMapper
import com.raman.RollMovie.viewmodel.favorite.FavoriteViewModel

@Composable
fun FavoriteScreen(favoriteViewModel: FavoriteViewModel, navController: NavController) {

    favoriteViewModel.getAllFavoriteMovie()

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.White)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        val favoriteData = favoriteViewModel.favoriteMovie.collectAsState().value

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(top = 10.dp)
        ) {

            Spacer(modifier = Modifier.width(4.dp))

            UseFulButton(image = R.drawable.ic_arrow_back) {
                navController.popBackStack()
            }

            Text(
                text = "Favorites",
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

        if (favoriteData == null) {

            val composition by rememberLottieComposition(
                LottieCompositionSpec.RawRes(R.raw.no_data)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(120.dp))

                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.size(260.dp)
                )

            }

        } else {

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.padding(top = 10.dp, start = 4.dp, end = 4.dp, bottom = 10.dp)
            ) {
                items(favoriteData.size) {
                    MinimalLazyItem(data = favoriteMapper(favoriteData)[it]) { id ->
                        navController.navigate(AppScreens.DetailScreen.route + "/" + id + "/" + if (favoriteData[it].isMovie) ApiConstants.MOVIE else ApiConstants.TV_SHOW)
                        favoriteViewModel.searchFavoriteMovie(id)
                    }
                }
            }

        }

    }

}