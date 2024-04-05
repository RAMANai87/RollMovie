package com.raman.RollMovie.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.mainFont
import com.raman.RollMovie.ui.theme.overviewColor
import com.raman.RollMovie.utils.ApiConstants

@Composable
fun MinimalLazyItem(data : MovieModel, onItemClicked: (id: Int) -> Unit) {

    Card(
        modifier = Modifier
            .size(180.dp, 230.dp)
            .padding(end = 12.dp)
            .clickable { onItemClicked.invoke(data.id) },
        elevation = CardDefaults.cardElevation(
            4.dp
        ),
        shape = Shapes.small,
        colors = CardDefaults.cardColors(
            Color.White
        )
    ) {

        with(data) {

            AsyncImage(
                model = ApiConstants.Utils.IMAGE_URL_TEST,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = title,
                modifier = Modifier.fillMaxWidth().padding(start = 6.dp),
                textAlign = TextAlign.Start,
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = mainFont),
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "$overview...",
                modifier = Modifier.fillMaxWidth().padding(start = 6.dp),
                textAlign = TextAlign.Start,
                style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Medium, color = overviewColor),
                maxLines = 2
            )

        }

    }

}