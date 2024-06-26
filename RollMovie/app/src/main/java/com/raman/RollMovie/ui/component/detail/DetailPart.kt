package com.raman.RollMovie.ui.component.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.raman.RollMovie.R
import com.raman.RollMovie.model.data.detail.DetailModel
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.backgroundCard
import com.raman.RollMovie.ui.theme.mainFont
import com.raman.RollMovie.ui.theme.secondaryShapes
import com.raman.RollMovie.utils.common.buildImageUrl
import com.raman.RollMovie.utils.common.genreEditor
import com.raman.RollMovie.utils.mapper.castMapper
import com.raman.RollMovie.utils.mapper.crewMapper

@Composable
fun DetailBarMainMovie(data: DetailModel, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
    ) {

        AsyncImage(
            model = buildImageUrl(data.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .align(Alignment.TopCenter),
            error = painterResource(id = R.drawable.white_screen),
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 200.dp)
                .align(Alignment.Center)
                .verticalScroll(rememberScrollState())
        ) {

            DetailImage(data.image, data.title, data.vote)

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .clip(secondaryShapes.medium),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DetailBarSecondaryMovie(data = data)

                    Text(
                        text = "Overview",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 6.dp, top = 12.dp),
                        style = TextStyle(
                            color = mainFont,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular))
                        )
                    )

                    Text(
                        text = data.overview.ifEmpty { "No Caption for this movie" },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 6.dp, end = 6.dp, top = 4.dp),
                        style = TextStyle(
                            color = mainFont,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Start
                        )
                    )

                    if (data.productionCompany.isNotEmpty()) {
                        Text(
                            text = "Production Company",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, top = 10.dp),
                            style = TextStyle(
                                color = mainFont,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular))
                            )
                        )

                        DetailLazyRow(data = data.productionCompany)
                    }

                    if (data.castCrews.cast.isNotEmpty()) {
                        Text(
                            text = "Cast",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, top = 10.dp),
                            style = TextStyle(
                                color = mainFont,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular))
                            )
                        )

                        DetailCreditsLazyRow(data = castMapper(data.castCrews.cast))

                    }

                    if (data.castCrews.crew.isNotEmpty()) {
                        Text(
                            text = "Crew",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, top = 10.dp),
                            style = TextStyle(
                                color = mainFont,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular))
                            )
                        )

                        DetailCreditsLazyRow(data = crewMapper(data.castCrews.crew))
                    }

                }

            }

        }
    }

}

@Composable
fun DetailBarSecondaryMovie(data: DetailModel) {

    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(70.dp)
            .padding(top = 12.dp)
            .clip(Shapes.small),
        colors = CardDefaults.cardColors(containerColor = backgroundCard)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DetailSecondaryData(
                image = R.drawable.ic_alarm,
                title = if (data.time <= 0) "No runtime" else data.time.toString() + " min"
            )
            DetailSecondaryData(image = R.drawable.ic_realizedate, title = data.realizeDate)
            DetailSecondaryData(
                image = R.drawable.ic_genre,
                title = if (data.genre.isEmpty()) "No genre" else genreEditor(data.genre)
            )
        }

    }

}