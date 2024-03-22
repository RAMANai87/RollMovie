package com.raman.RollMovie.ui.features.mainScreen

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeScreen() {

    val context = LocalContext.current
    Toast.makeText(context, "Hello to every one", Toast.LENGTH_SHORT).show()

}