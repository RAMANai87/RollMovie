package com.raman.RollMovie.ui.component.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.raman.RollMovie.R
import com.raman.RollMovie.model.data.detail.movie.ProductionCompany
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.backgroundCard
import com.raman.RollMovie.ui.theme.mainFont
import com.raman.RollMovie.ui.theme.secondaryShapes
import com.raman.RollMovie.utils.buildImageUrl

@Composable
fun DetailLazyRowItem(data: ProductionCompany) {


    Column(
        modifier = Modifier
            .size(70.dp, 100.dp)
            .padding(end = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        AsyncImage(
            model = buildImageUrl(data.logo_path),
            contentDescription = null,
            modifier = Modifier
                .size(66.dp)
                .padding(4.dp)
                .clip(secondaryShapes.large),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.flame_sign_up),
            error = painterResource(id = R.drawable.flame_sign_up)
        )

        Text(
            text = data.name,
            style = TextStyle(
                color = mainFont,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )

    }

}