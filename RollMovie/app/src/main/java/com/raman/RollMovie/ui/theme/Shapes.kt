package com.raman.RollMovie.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    large = RoundedCornerShape(28.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(14.dp),
    extraLarge = RoundedCornerShape(bottomEnd = 300.dp, bottomStart = 300.dp),
    extraSmall = RoundedCornerShape(8.dp)
)

val secondaryShapes = Shapes(
    large = RoundedCornerShape(50),
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(
        topStart = 40.dp,
        topEnd = 40.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    )
)