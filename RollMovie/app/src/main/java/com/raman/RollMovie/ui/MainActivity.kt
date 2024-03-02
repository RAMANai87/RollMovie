package com.raman.RollMovie.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raman.RollMovie.ui.features.detail.DetailScreen
import com.raman.RollMovie.ui.features.favorite.FavoriteScreen
import com.raman.RollMovie.ui.features.profile.ProfileScreen
import com.raman.RollMovie.ui.features.search.SearchScreen
import com.raman.RollMovie.ui.features.setting.SettingScreen
import com.raman.RollMovie.ui.features.user.signIn.SignInScreen
import com.raman.RollMovie.ui.features.user.signIn.SignInViewModel
import com.raman.RollMovie.ui.features.user.signUp.FirstRunScreen
import com.raman.RollMovie.ui.features.user.signUp.SignUpScreen
import com.raman.RollMovie.ui.features.user.signUp.SignUpViewModel
import com.raman.RollMovie.ui.theme.RollMovieTheme
import com.raman.RollMovie.utils.AppScreens

class MainActivity : ComponentActivity() {
    // initialize ViewModels
    private val signUpViewModel :SignUpViewModel by viewModels()
    private val signInViewModel :SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RollMovieTheme {
                RollMovieUi()
            }
        }
    }

    @Composable
    fun RollMovieUi() {

        val myNavController = rememberNavController()

        NavHost(navController = myNavController, startDestination = AppScreens.MainScreen.route) {

            composable(
                route = AppScreens.MainScreen.route
            ) {
                FirstRunScreen(myNavController)
            }

            composable(
                route = AppScreens.ProfileScreen.route
            ) {
                ProfileScreen()
            }

            composable(
                route = AppScreens.SearchScreen.route
            ) {
                SearchScreen()
            }

            composable(
                route = AppScreens.SettingScreen.route
            ) {
                SettingScreen()
            }

            composable(
                route = AppScreens.SignUpScreen.route
            ) {
                SignUpScreen(signUpViewModel, myNavController)
            }

            composable(
                route = AppScreens.FavoriteScreen.route
            ) {
                FavoriteScreen()
            }

            composable(
                route = AppScreens.DetailScreen.route
            ) {
                DetailScreen()
            }

            composable(
                route = AppScreens.EditProfileScreen.route
            ) {

            }

            composable(
                route = AppScreens.SignInScreen.route
            ) {
                SignInScreen(signInViewModel, myNavController)
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RollMovieTheme {
    }
}