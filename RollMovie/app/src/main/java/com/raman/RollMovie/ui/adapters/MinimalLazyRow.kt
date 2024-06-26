package com.raman.RollMovie.ui.adapters

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raman.RollMovie.R
import com.raman.RollMovie.model.data.MovieModel
import com.raman.RollMovie.ui.component.lazyItem.MinimalLazyItem
import com.raman.RollMovie.ui.theme.mainFont
import com.raman.RollMovie.ui.theme.primaryColor

@Composable
fun MinimalLazyRow(
    titleText: String,
    data: List<MovieModel>,
    onSeeAllClicked: () -> Unit,
    onItemClicked: (id: Int) -> Unit
) {

    Column(
        modifier = Modifier.padding(8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = titleText,
                modifier = Modifier.padding(start = 8.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
                    color = mainFont
                )
            )

            TextButton(
                onClick = { onSeeAllClicked.invoke() },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(
                    text = "See all",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
                        color = primaryColor
                    )
                )
            }

        }

        LazyRow(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .height(240.dp),
            contentPadding = PaddingValues(start = 8.dp)
        ) {

            items(10) {
                MinimalLazyItem(data[it]) { uri ->
                    onItemClicked(uri)
                }
            }

        }

    }

}

