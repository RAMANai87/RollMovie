package com.raman.RollMovie.ui.adapters

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
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
import com.raman.RollMovie.ui.component.FlatLazyItem
import com.raman.RollMovie.ui.component.MinimalLazyItem
import com.raman.RollMovie.ui.theme.mainFont

@Composable
fun FlatLazyColumn(titleText: String,data :List<MovieModel>, onItemClicked: (id: Int) -> Unit) {

    Column(
        modifier = Modifier.padding(top = 8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(14.dp),
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

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            contentPadding = PaddingValues(bottom = 12.dp, top = 10.dp)
        ) {

            items(4) {
                FlatLazyItem(data = data[it]) {id ->
                    onItemClicked.invoke(id)
                }
            }

        }

    }

}