package com.raman.RollMovie.ui.component.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.borderStrokeColor
import com.raman.RollMovie.ui.theme.mainFont

@Composable
fun DetailChip(title: String) {

    Card(
        modifier = Modifier
            .height(14.dp)
            .padding(end = 2.dp)
            .clip(Shapes.small),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(3.dp),
        border = BorderStroke(1.dp, borderStrokeColor)
    ) {

        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp),
            style = TextStyle(
                color = mainFont,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )

    }

}