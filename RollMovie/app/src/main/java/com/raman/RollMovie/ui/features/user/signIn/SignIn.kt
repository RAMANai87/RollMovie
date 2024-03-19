package com.raman.RollMovie.ui.features.user.signIn

import android.widget.Toast
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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.raman.RollMovie.model.data.Resource
import com.raman.RollMovie.ui.features.user.signUp.MainTextField
import com.raman.RollMovie.ui.features.user.signUp.PasswordTextField
import com.raman.RollMovie.ui.features.user.signUp.SignUpIcon
import com.raman.RollMovie.ui.features.user.signUp.TitleTextField
import com.raman.RollMovie.ui.features.user.signUp.UserViewModel
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.mainFont
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.utils.AppScreens

@Composable
fun SignInScreen(useViewModel: UserViewModel, navController: NavController) {

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
            SignInPart(useViewModel, navController)
        }

    }

}

@Composable
fun SignInPart(userViewModel: UserViewModel, navController: NavController) {

    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val loginFlow = userViewModel.signInFlow.collectAsState()

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
                email = it
            }

            TitleTextField("Password :")
            PasswordTextField(
                edtValue = password,
                hint = "password",
                icon = R.drawable.ic_password
            ) {
                password = it
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

                TextButton(onClick = {
                    navController.navigate(AppScreens.SignUpScreen.route) {
                        popUpTo(AppScreens.SignInScreen.route) {
                            inclusive = true
                        }
                    }
                }) {

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
                onClick = {
                    if (email.isNotEmpty()) {
                        if (email.contains("@gmail.com")) {
                            if (password.length >= 8) {

                                // sign in user
                                userViewModel.signIn(email, password)

                            } else {
                                Toast.makeText(
                                    context,
                                    "your password has more than 7 parameter",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "your email is not valid",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(context, "please insert your email", Toast.LENGTH_SHORT)
                            .show()
                    }
                },
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

    loginFlow.value?.let {

        when(it) {
            is Resource.Failure -> Toast.makeText(
                context,
                "Sign in you hit an error",
                Toast.LENGTH_SHORT
            ).show()
            Resource.Loading -> {
                LinearProgressIndicator( modifier = Modifier.fillMaxWidth(), color = Color.White)
            }
            is Resource.Success -> navController.navigate(AppScreens.HomeScreen.route) {
                popUpTo(AppScreens.HomeScreen.route) { inclusive = true }
            }
        }

    }

}

