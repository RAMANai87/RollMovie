package com.raman.RollMovie.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.raman.RollMovie.R
import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.mainFont
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.utils.buildImageUrl

@Composable
fun FlatLazyItem(data: MovieModel, onItemClicked: (id: Int) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp)
            .padding(top = 10.dp, start = 16.dp, end = 16.dp)
            .clickable { onItemClicked.invoke(data.id) },
        elevation = CardDefaults.cardElevation(
            1.dp
        ),
        shape = Shapes.small,
        colors = CardDefaults.cardColors(
            Color.White
        ),
        border = BorderStroke(1.dp, primaryColor)
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .padding(start = 8.dp, top = 5.dp, bottom = 5.dp)
                    .clip(Shapes.small),
                model = buildImageUrl(data.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = data.title,
                    style = TextStyle(
                        color = mainFont,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                // realize date part
                DetailAdapter(resId = R.drawable.ic_realizedate, text = data.realizeDate)

                // vote part
                DetailAdapter(resId = R.drawable.ic_star, text = data.vote.toString())

            }

        }

    }

}