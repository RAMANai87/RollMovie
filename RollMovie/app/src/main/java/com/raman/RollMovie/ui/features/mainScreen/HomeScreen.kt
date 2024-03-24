package com.raman.RollMovie.ui.features.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raman.RollMovie.R
import com.raman.RollMovie.ui.features.user.signUp.SignUpScreen
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.barFontMain
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.utils.AppScreens

@Composable
fun HomeScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.White)

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

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen(rememberNavController())
}
