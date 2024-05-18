package com.raman.RollMovie.ui.component

import android.widget.AdapterView.OnItemClickListener
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raman.RollMovie.R
import com.raman.RollMovie.model.data.detail.DetailModel
import com.raman.RollMovie.ui.component.detail.DetailSecondaryData
import com.raman.RollMovie.ui.theme.backGroundMain
import com.raman.RollMovie.ui.theme.secondaryShapes
import com.raman.RollMovie.utils.genreEditor
import com.raman.RollMovie.utils.spokenLangEditor

@Composable
fun MainLazyItem(
    data: DetailModel,
    isFavoriteMovie: (Boolean) -> Unit,
    onItemClick :(id :Int) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(260.dp)
            .clickable { onItemClick.invoke(data.id) },
        colors = CardDefaults.cardColors(containerColor = backGroundMain),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            MainImageItem(imageUrl = data.image, vote = data.vote)

            Column(
                modifier = Modifier
                    .height(240.dp)
                    .padding(top = 6.dp, bottom = 6.dp, start = 14.dp)
            ) {
                Text(
                    text = data.title,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold
                    ),
                    maxLines = 1
                )

                DetailSecondaryData(image = R.drawable.ic_realizedate, title = data.realizeDate)
                Spacer(modifier = Modifier.height(4.dp))
                DetailSecondaryData(image = R.drawable.ic_genre, title = genreEditor(data.genre))
                Spacer(modifier = Modifier.height(4.dp))
                DetailSecondaryData(
                    image = R.drawable.ic_person,
                    title = spokenLangEditor(data.spokenLang)
                )
            }

            var isFavorite by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier
                    .size(50.dp)
                    .padding(bottom = 70.dp, start = 20.dp),
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

        }
    }

}