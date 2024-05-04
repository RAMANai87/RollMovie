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
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.raman.RollMovie.ui.adapters.MinimalLazyRow
import com.raman.RollMovie.ui.adapters.SliderImagesView
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.barFontMain
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.utils.AppScreens
import com.raman.RollMovie.viewmodel.app.MovieViewModel

@Composable
fun HomeScreen(movieViewModel: MovieViewModel, navController: NavController) {

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
                    if (movieViewModel.inProgress.value) {
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
                    } else if (movieViewModel.isHitError.value) {

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
                                onClick = { movieViewModel.getRemoteData() },
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
                        MovieScreen(movieViewModel = movieViewModel) {
                            navController.navigate(AppScreens.DetailScreen.route)
                        }
                    }
                }

                1 -> {
                    TvShowScreen()
                }
            }
        }
    }
}

//----------------------------------------------------------------------------------------
@Composable
private fun MovieScreen(movieViewModel: MovieViewModel, onItemClicked: () -> Unit) {

    Column {

        // get data from network
        val dataPopular = movieViewModel.popularFlow.collectAsState()
        val dataTopRated = movieViewModel.topRatedFlow.collectAsState()
        val dataUpComing = movieViewModel.upComingFlow.collectAsState()
        val dataTrending = movieViewModel.trendingFlow.collectAsState()
        val dataDiscover = movieViewModel.discoverFlow.collectAsState()
        val dataNowPlaying = movieViewModel.nowPlayingFlow.collectAsState()

        if (dataPopular.value!!.isNotEmpty()) {
            if (dataDiscover.value!!.isNotEmpty()) {
                if (dataNowPlaying.value!!.isNotEmpty()) {
                    if (dataTrending.value!!.isNotEmpty()) {
                        if (dataTopRated.value!!.isNotEmpty()) {
                            if (dataUpComing.value!!.isNotEmpty()) {
                                // set data and show them
                                SliderImagesView(titleText = "Popular Movie", data = dataPopular.value!!) {
                                    onItemClicked.invoke()
                                }

                                MinimalLazyRow(titleText = "TopRated Movie", data = dataTopRated.value!!) {
                                    onItemClicked.invoke()
                                }

                                MinimalLazyRow(titleText = "NowPlaying Movie", data = dataNowPlaying.value!!) {
                                    onItemClicked.invoke()
                                }

                                MinimalLazyRow(titleText = "Discover Movie", data = dataDiscover.value!!) {
                                    onItemClicked.invoke()
                                }

                                MinimalLazyRow(titleText = "Trending Movie", data = dataTrending.value!!) {
                                    onItemClicked.invoke()
                                }

                                MinimalLazyRow(titleText = "UpComing Movie", data = dataUpComing.value!!) {
                                    onItemClicked.invoke()
                                }
                            }
                        }
                    }
                }
            }
        }

    }

}

//--------------------------------------------------------------------------------
@Composable
private fun TvShowScreen() {
    Text(text = "Tv show part")
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

            Image(painter = painterResource(id = R.drawable.heart_ic),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp, 24.dp)
                    .clickable { onFavoriteClicked.invoke() }
            )

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

data class TabItems(
    val tabName: String
)
