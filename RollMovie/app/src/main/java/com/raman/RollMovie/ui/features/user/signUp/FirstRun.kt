package com.raman.RollMovie.ui.features.user.signUp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raman.RollMovie.R
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.utils.common.AppScreens
import com.raman.RollMovie.ui.component.SliderImages

@Composable
fun FirstRunScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.White)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        SliderImages()

        Column(
            modifier = Modifier
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    navController.navigate(AppScreens.SignUpScreen.route) {
                        popUpTo(AppScreens.SignUpScreen.route) {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 6.dp)
            ) {

                Text(
                    text = "Sign Up",
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )

            }

            Spacer(modifier = Modifier.height(2.dp))

            TextButton(onClick = {
                navController.navigate(AppScreens.SignInScreen.route) {
                    popUpTo(AppScreens.SignInScreen.route) {
                        inclusive = true
                    }
                }
            }) {

                Text(
                    text = "Log In",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
                        color = primaryColor,
                    )
                )

            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun FirstRunPreview() {
    FirstRunScreen(navController = rememberNavController())
}