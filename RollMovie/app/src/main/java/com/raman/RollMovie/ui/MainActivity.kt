package com.raman.RollMovie.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raman.RollMovie.model.data.Resource
import com.raman.RollMovie.ui.features.detail.DetailScreen
import com.raman.RollMovie.ui.features.favorite.FavoriteScreen
import com.raman.RollMovie.ui.features.mainScreen.HomeScreen
import com.raman.RollMovie.ui.features.profile.EditProfileScreen
import com.raman.RollMovie.ui.features.profile.ProfileScreen
import com.raman.RollMovie.ui.features.search.SearchScreen
import com.raman.RollMovie.ui.features.setting.SettingScreen
import com.raman.RollMovie.ui.features.user.signIn.SignInScreen
import com.raman.RollMovie.ui.features.user.signUp.FirstRunScreen
import com.raman.RollMovie.ui.features.user.signUp.SignUpScreen
import com.raman.RollMovie.ui.features.user.signUp.UserViewModel
import com.raman.RollMovie.ui.theme.RollMovieTheme
import com.raman.RollMovie.utils.AppScreens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    // initialize ViewModels
    private val userViewModel :UserViewModel by viewModels()

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
                if (userViewModel.currentUser != null) {
                    HomeScreen(myNavController)
                } else {
                    FirstRunScreen(navController = myNavController)
                }
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
                SignUpScreen(userViewModel, myNavController)
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
                EditProfileScreen()
            }

            composable(
                route = AppScreens.SignInScreen.route
            ) {
                SignInScreen(userViewModel, myNavController)
            }

            composable(
                route = AppScreens.HomeScreen.route
            ) {
                HomeScreen(myNavController)
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