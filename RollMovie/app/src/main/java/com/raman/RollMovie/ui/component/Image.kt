package com.raman.RollMovie.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.raman.RollMovie.R
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.utils.common.buildImageUrl
import com.raman.RollMovie.utils.common.voteEditor

@Composable
fun MainImageItem(imageUrl: String?, vote: Double) {

    Card(
        modifier = Modifier
            .size(120.dp, 170.dp)
            .clip(Shapes.small)
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            AsyncImage(
                model = buildImageUrl(imageUrl),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.no_image),
                error = painterResource(id = R.drawable.no_image)
            )

            Card(
                modifier = Modifier
                    .size(56.dp, 28.dp)
                    .align(Alignment.TopStart)
                    .padding(top = 4.dp, start = 4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(0.75f))
            ) {

                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )

                    Text(
                        text = voteEditor(vote),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = primaryColor
                        ),
                        maxLines = 1
                    )

                }

            }

        }
    }
}