package com.raman.RollMovie.ui.component.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.secondaryShapes
import com.raman.RollMovie.viewmodel.favorite.FavoriteViewModel

@Composable
fun FavoriteButton(
    color: Color,
    id :Int,
    favoriteViewModel: FavoriteViewModel,
    onFavoriteClicked :(Boolean) -> Unit
) {

    favoriteViewModel.searchFavoriteMovie(id)

    var isFavorite = favoriteViewModel.isFavorite.value

    Card(
        modifier = Modifier.size(36.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(0.75f))
    ) {
        IconToggleButton(
            checked = isFavorite,
            onCheckedChange = {
                isFavorite = !isFavorite
                onFavoriteClicked.invoke(isFavorite)
            }
        ) {
            Icon(
                tint = color,
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