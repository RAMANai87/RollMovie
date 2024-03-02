package com.raman.RollMovie.ui.features.user.signIn

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raman.RollMovie.R
import com.raman.RollMovie.ui.features.user.signUp.MainTextField
import com.raman.RollMovie.ui.features.user.signUp.PasswordTextField
import com.raman.RollMovie.ui.features.user.signUp.SignUpIcon
import com.raman.RollMovie.ui.features.user.signUp.TitleTextField
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.mainFont
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.utils.AppScreens

@Composable
fun SignInScreen(signInViewModel :SignInViewModel, navController: NavController) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(primaryColor)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Surface(
            color = primaryColor,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 50.dp)
            ) {
                Text(
                    text = "I am glad that you come back",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.demoloviecloud)),
                        color = Color.White,
                    )
                )
                Text(
                    text = "Wish you had a good adventure",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.demoloviecloud)),
                        color = Color.White,
                    )
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignInPart(signInViewModel, navController)
        }

    }

}

@Composable
fun SignInPart(signInViewModel: SignInViewModel, navController: NavController) {

    val email = signInViewModel.email.value
    val password = signInViewModel.password.value

    Card(
        modifier = Modifier
            .fillMaxHeight(0.66f)
            .fillMaxWidth(0.85f)
            .padding(top = 20.dp)
            .clip(Shapes.large),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(4.dp, primaryColor)
    ) {

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            SignUpIcon(R.drawable.techny_signing_in_to_user_account)

            TitleTextField("Enter your email :")
            MainTextField(
                email,
                "Email",
                R.drawable.ic_email
            ) {
                signInViewModel.email.value = it
            }

            TitleTextField("Password :")
            PasswordTextField(
                edtValue = password,
                hint = "password",
                icon = R.drawable.ic_password
            ) {
                signInViewModel.password.value = it
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "I do not have an account, already !",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
                        color = mainFont,
                    ),
                    modifier = Modifier
                        .padding(end = 1.dp)
                )

                TextButton(onClick = {navController.navigate(AppScreens.SignUpScreen.route) {
                    popUpTo(AppScreens.SignInScreen.route){
                        inclusive = true
                    }
                }}) {

                    Text(
                        text = "Sign Up",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
                            color = primaryColor,
                        )
                    )

                }

            }

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(top = 6.dp)
            ) {

                Text(
                    text = "Log In",
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )

            }

        }

    }

}

