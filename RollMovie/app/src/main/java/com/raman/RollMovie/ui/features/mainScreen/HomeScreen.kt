package com.raman.RollMovie.ui.features.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.raman.RollMovie.ui.component.detail.UseFulButton
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.barFontMain
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.utils.remote.ApiConstants
import com.raman.RollMovie.utils.AppScreens
import com.raman.RollMovie.utils.TabItems
import com.raman.RollMovie.viewmodel.app.AppViewModel
import com.raman.RollMovie.viewmodel.favorite.FavoriteViewModel

@Composable
fun HomeScreen(appViewModel: AppViewModel, navController: NavController, favoriteViewModel: FavoriteViewModel) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        val systemUiController = rememberSystemUiController()
        systemUiController.setStatusBarColor(Color.White)

        val composition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.no_internet_anim)
        )

        val tabItems = listOf(
            TabItems("Movies"),
            TabItems("Tv Shows")
        )

        RollMovieAppBar(onSearchClicked = {
            navController.navigate(AppScreens.SearchScreen.route)
        }, onFavoriteClicked = {
            navController.navigate(AppScreens.FavoriteScreen.route)
        })

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            var selectedTabIndex by remember { mutableIntStateOf(0) }

            TabRow(selectedTabIndex = selectedTabIndex) {
                tabItems.forEachIndexed { index, item ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Text(
                                text = item.tabName,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                        }
                    )
                }
            }

            when (selectedTabIndex) {
                0 -> {
                    if (appViewModel.inProgress.value) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceAround,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Spacer(modifier = Modifier.height(200.dp))

                            CircularProgressIndicator(
                                color = primaryColor,
                                modifier = Modifier.padding(100.dp)
                            )
                        }
                    } else if (appViewModel.isHitError.value) {

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
                                onClick = { appViewModel.getRemoteDataMovie() },
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
                        MovieScreen(appViewModel = appViewModel) { id ->
                            navController.navigate(AppScreens.DetailScreen.route + "/" + id + "/" + ApiConstants.MOVIE)
                            favoriteViewModel.searchFavoriteMovie(id)
                        }
                    }
                }

                1 -> {
                    if (appViewModel.inProgressTvShow.value) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceAround,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Spacer(modifier = Modifier.height(200.dp))

                            CircularProgressIndicator(
                                color = primaryColor,
                                modifier = Modifier.padding(100.dp)
                            )
                        }
                    } else if (appViewModel.isHitErrorTvShow.value) {

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
                                onClick = { appViewModel.getRemoteDataTvShow() },
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
                        TvShowScreen(appViewModel) { id ->
                            navController.navigate(AppScreens.DetailScreen.route + "/" + id + "/" + ApiConstants.TV_SHOW)
                            favoriteViewModel.searchFavoriteMovie(id)
                        }
                    }
                }
            }
        }
    }
}

// App bar
@Composable
private fun RollMovieAppBar(onSearchClicked: () -> Unit, onFavoriteClicked: () -> Unit) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.padding(start = 10.dp))

            Image(
                painter = painterResource(id = R.mipmap.app_icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp, 24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            UseFulButton(image = R.drawable.heart_ic) {
                onFavoriteClicked.invoke()
            }

            Spacer(modifier = Modifier.width(20.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .padding(end = 10.dp)
                    .clip(Shapes.large)
                    .clickable { onSearchClicked.invoke() },
                color = primaryColor
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {

                    Image(
                        modifier = Modifier.padding(start = 16.dp),
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null
                    )

                    Text(
                        text = "Ask me to tell you",
                        modifier = Modifier.padding(start = 10.dp),
                        textAlign = TextAlign.Center,
                        color = barFontMain,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )

                }

            }

        }

    }

}
