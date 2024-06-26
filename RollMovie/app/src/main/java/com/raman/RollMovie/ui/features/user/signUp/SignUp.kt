package com.raman.RollMovie.ui.features.user.signUp

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raman.RollMovie.R
import com.raman.RollMovie.model.data.HttpResult
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.ui.theme.mainFont
import com.raman.RollMovie.ui.theme.primaryColor
import com.raman.RollMovie.utils.common.AppScreens
import com.raman.RollMovie.viewmodel.user.UserViewModel

@Composable
fun SignUpScreen(userViewModel: UserViewModel?, navControl: NavController) {

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
            SignUpPart(userViewModel, navControl)
        }

    }

}

@Composable
fun SignUpPart(userViewModel: UserViewModel?, navController: NavController) {

    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var checked by remember {
        mutableStateOf(false)
    }

    val signUpFlow = userViewModel?.signUpFlow?.collectAsState()

    Card(
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .padding(top = 20.dp)
            .clip(Shapes.large),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(4.dp, primaryColor)
    ) {

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SignUpIcon(R.drawable.flame_sign_up)

            TitleTextField("Enter your name :")
            MainTextField(
                name,
                "Name",
                R.drawable.ic_person
            ) {
                name = it
            }

            TitleTextField("Email :")
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

            TitleTextField("Confirm Your Password :")
            PasswordTextField(
                edtValue = confirmPassword,
                hint = "confirm password",
                icon = R.drawable.ic_password
            ) {
                confirmPassword = it
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Did you have an account ?",
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
                    navController.navigate(AppScreens.SignInScreen.route) {
                        popUpTo(AppScreens.SignUpScreen.route) {
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

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 2.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "I accept the",
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
                    navController.navigate(AppScreens.RulesScreen.route)
                }) {

                    Text(
                        text = "Rules",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(R.font.mouldy_cheese_regular)),
                            color = primaryColor,
                        )
                    )

                }
                
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    modifier = Modifier.padding(start = 2.dp)
                )

            }

            if (checked) {
                Button(
                    onClick = {

                        if (name.isNotEmpty()) {
                            if (email.isNotEmpty()) {
                                if (email.contains("@gmail.com")) {
                                    if (password.length >= 8) {
                                        if (password == confirmPassword) {

                                            // sign up user
                                            userViewModel?.signUp(name, email, password)

                                        } else {
                                            Toast.makeText(
                                                context,
                                                "your password not equal with confirm password",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()
                                        }
                                    } else {
                                        Toast.makeText(
                                            context,
                                            "should your password more than 8 parameter",
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
                        } else {
                            Toast.makeText(context, "please insert your name", Toast.LENGTH_SHORT)
                                .show()
                        }

                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(top = 2.dp, bottom = 8.dp)
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

    signUpFlow?.value?.let {

        when (it) {
            is HttpResult.Failure -> Toast.makeText(
                context,
                "Sign up you hit an error ",
                Toast.LENGTH_SHORT
            ).show()

            HttpResult.Loading -> {}

            is HttpResult.Success -> {
                navController.navigate(AppScreens.HomeScreen.route) {
                    popUpTo(AppScreens.HomeScreen.route) { inclusive = true }
                }
                Toast.makeText(context, "Sign up was successful", Toast.LENGTH_LONG).show()
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

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignUpScreen(userViewModel = null, navControl = rememberNavController())
}

