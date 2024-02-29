package com.raman.RollMovie.ui.features.user.signUp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raman.RollMovie.R
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.backgroundCard
import com.raman.RollMovie.ui.theme.mainFont
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.utils.AppScreens

@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel, navControl: NavController) {

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
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = "Welcome to RollMovie",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.demoloviecloud)),
                        color = Color.White,
                    )
                )
                Text(
                    text = "it is time to find your favorite movies",
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
            SignUpPart(signUpViewModel, navControl)
        }

    }

}

@Composable
fun SignUpPart(signUpViewModel: SignUpViewModel, navControl: NavController) {

    val name = signUpViewModel.name.value
    val email = signUpViewModel.email.value
    val password = signUpViewModel.password.value
    val confirmPassword = signUpViewModel.confirmPassword.value

    Card(
        modifier = Modifier
            .fillMaxHeight(0.88f)
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

            SignUpIcon(R.drawable.flame_sign_up)

            TitleTextField("Enter your name :")
            MainTextField(
                name,
                "Name",
                R.drawable.ic_person
            ) {
                signUpViewModel.name.value = it
            }

            TitleTextField("Email :")
            MainTextField(
                email,
                "Email",
                R.drawable.ic_email
            ) {
                signUpViewModel.email.value = it
            }

            TitleTextField("Password :")
            PasswordTextField(
                edtValue = password,
                hint = "password",
                icon = R.drawable.ic_password
            ) {
                signUpViewModel.password.value = it
            }

            TitleTextField("Confirm Your Password :")
            PasswordTextField(
                edtValue = confirmPassword,
                hint = "confirm password",
                icon = R.drawable.ic_password
            ) {
                signUpViewModel.confirmPassword.value = it
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Did you have an account, already ?",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
                        color = mainFont,
                    ),
                    modifier = Modifier
                        .padding(end = 1.dp)
                )

                TextButton(onClick = { navControl.navigate(AppScreens.SignInScreen.route) {
                    popUpTo(AppScreens.SignUpScreen.route){
                        inclusive = true
                    }
                } }) {

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

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(top = 6.dp)
            ) {

                Text(
                    text = "Sign Up",
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )

            }

        }

    }
}

@Composable
fun SignUpIcon(image: Int) {

    Image(
        modifier = Modifier
            .padding(14.dp)
            .size(140.dp),
        painter = painterResource(image),
        contentDescription = null
    )

}

@Composable
fun TitleTextField(title: String) {

    Text(
        text = title,
        textAlign = TextAlign.Start,
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
            color = mainFont,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp)
    )

}

@Composable
fun MainTextField(edtValue: String, hint: String, icon: Int, onValueChange: (String) -> Unit) {

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        label = { Text(hint) },
        value = edtValue,
        singleLine = true,
        onValueChange = onValueChange,
        placeholder = { Text(hint) },
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(bottom = 6.dp),
        shape = Shapes.medium,
        leadingIcon = { Icon(painterResource(icon), null) })

}

@Composable
fun PasswordTextField(edtValue: String, hint: String, icon: Int, onValueChange: (String) -> Unit) {

    val passwordVisible = remember { mutableStateOf(false) }

    OutlinedTextField(
        label = { Text(hint) },
        value = edtValue,
        singleLine = true,
        onValueChange = onValueChange,
        placeholder = { Text(hint) },
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(bottom = 6.dp),
        shape = Shapes.medium,
        leadingIcon = { Icon(painterResource(icon), null) },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {

            val image = if (passwordVisible.value) painterResource(R.drawable.ic_invisible)
            else painterResource(R.drawable.ic_visible)

            Icon(
                painter = image,
                contentDescription = null,
                modifier = Modifier.clickable { passwordVisible.value = !passwordVisible.value }
            )

        }
    )

}

