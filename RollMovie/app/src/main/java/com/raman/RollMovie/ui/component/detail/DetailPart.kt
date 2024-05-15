package com.raman.RollMovie.ui.component.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raman.RollMovie.R
import com.raman.RollMovie.model.data.detail.movie.DetailResponse
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.backgroundCard
import com.raman.RollMovie.ui.theme.mainFont

@Composable
fun DetailBarMainMovie(data: DetailResponse) {

    Card(
        modifier = Modifier
            .fillMaxWidth(0.82f)
            .height(160.dp)
            .clip(Shapes.medium),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundCard)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Text(
                text = data.original_title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp, end = 6.dp, top = 10.dp),
                style = TextStyle(
                    color = mainFont,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center
                ),
                maxLines = 1
            )

            Text(
                text = "Summery :",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp, top = 10.dp),
                style = TextStyle(
                    color = mainFont,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Start
                )
            )

            Text(
                text = data.overview,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp, end = 6.dp, top = 4.dp),
                style = TextStyle(
                    color = mainFont,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
            )

            Text(
                text = "Genres :",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp, top = 10.dp),
                style = TextStyle(
                    color = mainFont,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Start
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp, end = 6.dp, top = 4.dp)
            ) {

                data.genres.forEach { genre ->
                    DetailChip(title = genre.name)
                }

            }

            Text(
                text = "Spoken Languages :",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp, top = 10.dp),
                style = TextStyle(
                    color = mainFont,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Start
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp, end = 6.dp, top = 4.dp)
            ) {

                data.spoken_languages.forEach { language ->
                    DetailChip(title = language.english_name)
                }

            }

        }

    }

}

@Composable
fun DetailBarSecondaryMovie(data :DetailResponse) {

    Card(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .height(50.dp)
            .padding(bottom = 20.dp)
            .clip(Shapes.medium),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundCard)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DetailSecondaryData(image = R.drawable.ic_alarm, title = data.runtime.toString() + "min")
            DetailSecondaryData(image = R.drawable.ic_realizedate, title = data.release_date)
            DetailSecondaryData(image = R.drawable.ic_star, title = data.vote_average.toString())
        }

    }

}

@Composable
fun DetailBarMainTvShow() {


}

@Composable
fun DetailBarSecondaryTvShow() {

}