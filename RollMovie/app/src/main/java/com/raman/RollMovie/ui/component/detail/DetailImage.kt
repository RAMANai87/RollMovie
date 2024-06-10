package com.raman.RollMovie.ui.component.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.raman.RollMovie.R
import com.raman.RollMovie.utils.common.buildImageUrl

@Composable
fun DetailImage(image: String, title: String, voteAverage: Double) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            val isInError = remember {
                mutableStateOf(false)
            }

            AsyncImage(
                model = buildImageUrl(image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.no_image),
                error = painterResource(id = R.drawable.no_image),
                onError = { isInError.value = true },
                onSuccess = { isInError.value = false },
                onLoading = { isInError.value = true }
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .align(Alignment.BottomStart)
                    .padding(bottom = 16.dp, start = 12.dp, end = 12.dp)
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        color = if (isInError.value) Color.Black else Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold
                    ),
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(8.dp))

                RatingDetail(vote = voteAverage)

            }

        }

    }

}