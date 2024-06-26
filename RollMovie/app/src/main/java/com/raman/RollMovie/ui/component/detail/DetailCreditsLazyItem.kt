package com.raman.RollMovie.ui.component.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.raman.RollMovie.model.data.CreditsModel
import com.raman.RollMovie.ui.theme.secondaryShapes
import com.raman.RollMovie.utils.common.buildImageUrl

@Composable
fun DetailCreditsLazyRowItem(data: CreditsModel) {

    Row(
        modifier = Modifier
            .size(170.dp, 60.dp)
            .padding(end = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        AsyncImage(
            model = buildImageUrl(data.profile),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .padding(4.dp)
                .clip(secondaryShapes.large),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.white_screen),
            error = painterResource(id = R.drawable.white_screen)
        )

        Column {

            Text(
                text = data.name ?: "No_Data",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                ),
                maxLines = 1
            )

            Text(
                text = data.character ?: "No_Data",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                ),
                maxLines = 1
            )

        }

    }

}