package com.raman.RollMovie.ui.features.search

import android.widget.Toast
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
import com.raman.RollMovie.ui.adapters.MainLazyColumn
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.utils.AppScreens
import com.raman.RollMovie.utils.remote.ApiConstants
import com.raman.RollMovie.viewmodel.favorite.FavoriteViewModel
import com.raman.RollMovie.viewmodel.search.SearchViewModel

@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel,
    favoriteViewModel: FavoriteViewModel,
    navController: NavController
) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.White)

    var searchTextData by remember {
        mutableStateOf("")
    }

    var isMovieData by remember {
        mutableStateOf(true)
    }

    val searchData = searchViewModel.dataSearch.collectAsState().value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        if (searchViewModel.inProgress.value) {
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
        } else if (searchViewModel.hitError.value) {

            val composition by rememberLottieComposition(
                LottieCompositionSpec.RawRes(R.raw.no_internet_anim)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(50.dp))

                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.size(240.dp)
                )

                Button(
                    onClick = {
                        if (isMovieData) {
                            searchViewModel.getSearchMovie(searchTextData)
                        } else {
                            searchViewModel.getSearchTvShow(searchTextData)
                        }
                    },
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

            Spacer(modifier = Modifier.height(50.dp))

            if (searchData == null) {
                val composition by rememberLottieComposition(
                    LottieCompositionSpec.RawRes(R.raw.no_data)
                )

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    LottieAnimation(
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier.size(260.dp)
                    )

                }
            } else {
                MainLazyColumn(
                    data = searchData,
                    favoriteViewModel = favoriteViewModel,
                    isMovie = isMovieData
                ) { id ->
                    navController.navigate(AppScreens.DetailScreen.route + "/" + id + "/" + if (isMovieData) ApiConstants.MOVIE else ApiConstants.TV_SHOW)
                }
            }
        }

        TopAppBarSearch { isMovie, searchText ->
            searchTextData = searchText
            isMovieData = if (isMovie) {
                searchViewModel.getSearchMovie(searchText)
                true
            } else {
                searchViewModel.getSearchTvShow(searchText)
                false
            }

        }

    }

}

// =======================================================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSearch(onSearchClicked: (Boolean, String) -> Unit) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        color = Color.White
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            val searchType = remember {
                mutableStateOf("Movie")
            }

            var searchText by remember { mutableStateOf("") }
            val sheetState = rememberModalBottomSheetState()
            var isSheetOpen by rememberSaveable {
                mutableStateOf(false)
            }

            TextButton(onClick = {
                isSheetOpen = true
            }, modifier = Modifier.padding(start = 10.dp)) {

                Text(
                    text = searchType.value,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
                        color = Color.Black
                    )
                )

            }

            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text("Search") },
                value = searchText,
                singleLine = true,
                onValueChange = {
                    searchText = it
                    onSearchClicked.invoke (
                        searchType.value == "Movie", searchText
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(0.94f)
                    .padding(start = 10.dp),
                shape = Shapes.small,
                leadingIcon = { Icon(painterResource(R.drawable.ic_search), null) }
            )

            if (isSheetOpen) {

                ModalBottomSheet(
                    sheetState = sheetState,
                    onDismissRequest = { isSheetOpen = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top
                    ) {

                        TextButton(onClick = {
                            searchType.value = "Movie"
                            isSheetOpen = false
                        }) {

                            Text(
                                text = "Movie",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
                                    color = Color.Black,
                                    textAlign = TextAlign.Right
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp)
                            )

                        }

                        Divider(
                            thickness = 1.dp,
                            color = Color.Gray,
                            modifier = Modifier.padding(
                                top = 8.dp,
                                bottom = 8.dp,
                                start = 80.dp,
                                end = 80.dp
                            )
                        )

                        TextButton(onClick = {
                            searchType.value = "Tv Show"
                            isSheetOpen = false
                        }) {

                            Text(
                                text = "Tv Show",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
                                    color = Color.Black,
                                    textAlign = TextAlign.Right
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 10.dp)
                            )

                        }

                    }

                }

            }

        }
    }

}
