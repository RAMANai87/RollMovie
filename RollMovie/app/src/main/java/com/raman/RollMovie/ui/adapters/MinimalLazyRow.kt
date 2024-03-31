package com.raman.RollMovie.ui.adapters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.raman.RollMovie.R
import com.raman.RollMovie.model.data.movie.Result
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.mainFont
import com.raman.RollMovie.utils.buildImageUrl

@Composable
fun MinimalLazyRow(titleText: String, onItemClicked: (id: Int) -> Unit, data :List<Result>) {

    Column {

        Row(
            modifier = Modifier.fillMaxWidth().height(14.dp),
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

            Text(
                text = "See all",
                modifier = Modifier.padding(end = 12.dp),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
                    color = mainFont
                )
            )

        }

        LazyRow(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .height(240.dp),
            contentPadding = PaddingValues(start = 12.dp)
        ) {

            items(10) {
                LazyItem(data[it]) { uri ->
                    onItemClicked(uri)
                }
            }

        }

    }

}

@Composable
private fun LazyItem(data :Result ,onItemClicked: (id: Int) -> Unit) {

    Card(
        modifier = Modifier
            .padding(end = 12.dp)
            .size(120.dp, 220.dp)
            .clickable { onItemClicked.invoke(12) },
        elevation = CardDefaults.cardElevation(
            0.dp
        ),
        shape = Shapes.small,
        colors = CardDefaults.cardColors(
            Color.White
        )
    ) {

        with(data) {

            AsyncImage(
                model = buildImageUrl(poster_path),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(Shapes.small)
                    .height(150.dp),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = original_title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold),
                maxLines = 3
            )

        }

    }

}