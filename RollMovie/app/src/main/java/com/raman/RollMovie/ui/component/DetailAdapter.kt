package com.raman.RollMovie.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raman.RollMovie.R
import com.raman.RollMovie.ui.theme.mainFont

@Composable
fun DetailAdapter(resId: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = resId),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = text,
            style = TextStyle(
                color = mainFont,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.demoloviecloud))
            )
        )

    }

}