package com.raman.RollMovie.utils

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raman.RollMovie.R
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.mainFont
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.ui.theme.sliderColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SliderImages() {

    val images = listOf(
        R.drawable.first_run_pic1,
        R.drawable.first_run_pic2,
        R.drawable.first_run_pic3
    )

    ImageSlider(images = images)

}

@Composable
private fun ImageItem(imageRes: Int, pageNum: Int) {

    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(0.86f)
                .clip(Shapes.small)
                .height(400.dp)
        )

        when (pageNum) {
            0 -> {
                Text(
                    text = "RollMovie",
                    modifier = Modifier.fillMaxWidth().padding(top = 80.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.demoloviecloud)),
                        fontSize = 28.sp,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Popular movies and series with RollMovie",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        color = mainFont,
                        fontFamily = FontFamily(Font(R.font.demoloviecloud)),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }

            1 -> {
                Text(
                    text = "Search in movie land",
                    modifier = Modifier.fillMaxWidth().padding(top = 80.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.demoloviecloud)),
                        fontSize = 28.sp,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "We take you to new world",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        color = mainFont,
                        fontFamily = FontFamily(Font(R.font.demoloviecloud)),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }

            2 -> {
                Text(
                    text = "Just tell us your film",
                    modifier = Modifier.fillMaxWidth().padding(top = 80.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.demoloviecloud)),
                        fontSize = 28.sp,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "And find out anything you want",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        color = mainFont,
                        fontFamily = FontFamily(Font(R.font.demoloviecloud)),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ImageSlider(images: List<Int>) {

    val pageCount = images.size
    val pagerState = rememberPagerState(pageCount = {
        return@rememberPagerState pageCount
    })
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        while (true) {
            delay(7000)
            coroutineScope.launch {
                pagerState.animateScrollToPage((pagerState.currentPage + 1) % images.size)
            }
        }
    }

    HorizontalPager(
        state = pagerState,
        beyondBoundsPageCount = pageCount
    ) { page ->

        for (index in images.indices) {
            ImageItem(imageRes = images[page], page)
        }

    }

    Row(
        modifier = Modifier
            .padding(top = 70.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        repeat(pageCount) {

            val color = if (pagerState.currentPage == it) primaryColor else sliderColor
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(10.dp)
            )

        }

    }

}