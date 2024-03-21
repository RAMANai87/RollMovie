package com.raman.RollMovie.utils

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.raman.RollMovie.R
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.primaryColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SliderImages() {

    val images = listOf(
        R.drawable.ic_email,
        R.drawable.ic_password,
        R.drawable.ic_person
    )

    ImageSlider(images = images)

}

@Composable
fun ImageItem(imageRes: Int) {

    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxWidth()
            .clip(Shapes.small)
            .height(300.dp)
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(images: List<Int>) {

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
            ImageItem(imageRes = images[page])

        }

    }

    Row(
        modifier = Modifier
            .padding(bottom = 170.dp)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        repeat(pageCount) {

            val color = if (pagerState.currentPage == it) primaryColor else Color.Black
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