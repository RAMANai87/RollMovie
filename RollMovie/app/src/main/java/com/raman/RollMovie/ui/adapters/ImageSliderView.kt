package com.raman.RollMovie.ui.adapters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.raman.RollMovie.R
import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.mainFont
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.ui.theme.sliderColor
import com.raman.RollMovie.utils.buildImageUrl
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SliderImagesView(data: List<MovieModel>, titleText: String, onItemClicked: () -> Unit) {

    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(14.dp)
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = titleText,
                modifier = Modifier.padding(start = 12.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
                    color = mainFont
                )
            )

            TextButton(onClick = {}) {
                Text(
                    text = "See all",
                    modifier = Modifier.padding(end = 12.dp),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
                        color = primaryColor
                    )
                )
            }

        }

        ImageSlider(data, onItemClicked)

    }
}

@Composable
private fun ImageItem(imageUrl: String, onItemClicked: () -> Unit) {

    AsyncImage(
        contentDescription = null,
        model = buildImageUrl(imageUrl),
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp)
            .padding(top = 6.dp, start = 10.dp, end = 10.dp)
            .clip(Shapes.large)
            .clickable { onItemClicked.invoke() },
        contentScale = ContentScale.Crop
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ImageSlider(data: List<MovieModel>, onItemClicked: () -> Unit) {

    val pageCount = 10
    val pagerState = rememberPagerState(pageCount = {
        return@rememberPagerState pageCount
    })
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        while (true) {
            delay(7000)
            coroutineScope.launch {
                pagerState.animateScrollToPage((pagerState.currentPage + 1) % 10)
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(
            state = pagerState
        ) { page ->

            for (index in data.indices) {
                ImageItem(imageUrl = data[page].imageUrl, onItemClicked)
            }

        }

        Row(
            modifier = Modifier
                .padding(top = 10.dp)
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
                        .size(8.dp)
                )

            }

        }
    }

}