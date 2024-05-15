package com.raman.RollMovie.ui.component.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.raman.RollMovie.R

@Composable
fun BackButton() {

    Card(
        modifier = Modifier.size(30.dp),
        elevation = CardDefaults.cardElevation(
            2.dp
        )
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = null,
            modifier = Modifier.padding(5.dp)
        )

    }

}