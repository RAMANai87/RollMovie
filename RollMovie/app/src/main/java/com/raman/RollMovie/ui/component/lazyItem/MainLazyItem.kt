package com.raman.RollMovie.ui.component.lazyItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raman.RollMovie.R
import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.ui.component.MainImageItem
import com.raman.RollMovie.ui.component.detail.DetailSecondaryData
import com.raman.RollMovie.ui.theme.secondaryShapes

@Composable
fun MainLazyItem(
    data: MovieModel,
    isFavoriteMovie: (Boolean) -> Unit,
    onItemClick: (id: Int) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(top = 6.dp, end = 8.dp)
            .clickable { onItemClick.invoke(data.id) },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Row(
                modifier = Modifier.fillMaxSize().align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                MainImageItem(imageUrl = data.imageUrl, vote = data.vote)

                Column(
                    modifier = Modifier
                        .height(240.dp)
                        .padding(top = 6.dp, bottom = 6.dp, start = 14.dp)
                ) {
                    Text(
                        text = data.title,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold
                        ),
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = data.overview,
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold
                        ),
                        maxLines = 4
                    )
                    DetailSecondaryData(image = R.drawable.ic_realizedate, title = data.realizeDate)
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }

            var isFavorite by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 4.dp, end = 4.dp)
                    .align(Alignment.TopEnd),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(0.75f)),
                shape = secondaryShapes.small
            ) {
                IconToggleButton(
                    checked = isFavorite,
                    onCheckedChange = {
                        isFavorite = !isFavorite
                        isFavoriteMovie.invoke(isFavorite)
                    }
                ) {
                    Icon(
                        tint = Color.Red,
                        modifier = Modifier.padding(4.dp),
                        imageVector = if (isFavorite) {
                            Icons.Filled.Favorite
                        } else {
                            Icons.Default.FavoriteBorder
                        },
                        contentDescription = null
                    )
                }
            }

            if (data.adult) {
                Image(
                    painter = painterResource(id = R.drawable.ic_18),
                    contentDescription = null,
                    modifier = Modifier
                        .size(28.dp)
                        .padding(end = 4.dp)
                        .align(Alignment.CenterEnd)
                )
            }

        }
    }

}