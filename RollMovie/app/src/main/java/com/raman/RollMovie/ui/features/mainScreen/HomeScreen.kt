package com.raman.RollMovie.ui.features.mainScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
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
import com.raman.RollMovie.utils.MovieState
import com.raman.RollMovie.viewmodel.app.MovieViewModel
import kotlinx.coroutines.flow.collect

@Composable
fun HomeScreen(movieViewModel: MovieViewModel ,navController: NavController) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.White)

    if (movieViewModel.inProgress.value) {

        CircularProgressIndicator(
            modifier = Modifier.padding(horizontal = 200.dp, vertical = 400.dp),
            color = primaryColor
        )

    } else {

        val composition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.no_internet_anim)
        )

        val tabItems = listOf(
            TabItems("Movies"),
            TabItems("Tv Shows")
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {

            RollMovieAppBar(onSearchClicked = {
                navController.navigate(AppScreens.SearchScreen.route)
            }, onFavoriteClicked = {
                navController.navigate(AppScreens.FavoriteScreen.route)
            })

            Spacer(modifier = Modifier.height(56.dp))

            var selectedTabIndex by remember { mutableIntStateOf(0) }

            TabRow(selectedTabIndex = selectedTabIndex, modifier = Modifier.padding(top = 56.dp)) {
                tabItems.forEachIndexed { index, item ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(text = item.tabName) }
                    )
                }
            }

            Surface(
                modifier = Modifier
                    .padding(top = 110.dp)
            ) {
                when (selectedTabIndex) {
                    0 -> {
                        MovieScreen(movieViewModel) {navController.navigate(AppScreens.DetailScreen.route)}
                    }

                    1 -> {
                        TvShowScreen()
                    }
                }
            }

        }

    }

}

@Composable
fun MovieScreen(movieViewModel: MovieViewModel, onItemClicked : () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val dataPopular = movieViewModel.popularFlow.collectAsState()
        val dataTopRated = movieViewModel.topRatedFlow.collectAsState()
        dataPopular.value?.let {
            SliderImagesView(it, "Popular Movie") {
                onItemClicked.invoke()
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Log.v("data1", dataTopRated.toString())
        dataTopRated.value?.let {
            MinimalLazyRow("Top Rated Movie", it) {id ->
                onItemClicked.invoke()
            }
        }

    }

}

@Composable
fun TvShowScreen() {
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
                        color = barFontMain
                    )

                }

            }

        }

    }

}

data class TabItems(
    val tabName: String
)
