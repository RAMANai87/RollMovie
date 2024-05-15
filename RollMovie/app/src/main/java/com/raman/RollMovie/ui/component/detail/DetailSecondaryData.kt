package com.raman.RollMovie.ui.component.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raman.RollMovie.ui.theme.mainFont

@Composable
fun DetailSecondaryData(image: Int, title: String) {

    Column(
        modifier = Modifier.size(34.dp, 50.dp)
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.size(30.dp).align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 2.dp, end = 2.dp),
            style = TextStyle(
                color = mainFont,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            maxLines = 1
        )

    }

}