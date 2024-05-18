package com.raman.RollMovie.ui.component.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun UseFulButton(image :Int, onBackPressed : () -> Unit) {

    Card(
        modifier = Modifier.size(36.dp).clickable { onBackPressed() },
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(0.75f))
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.padding(5.dp)
        )

    }

}