package com.raman.RollMovie.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
import com.raman.RollMovie.viewmodel.user.UserViewModel
import com.raman.RollMovie.ui.theme.RollMovieTheme
import com.raman.RollMovie.utils.remote.ApiConstants
import com.raman.RollMovie.utils.AppScreens
import com.raman.RollMovie.viewmodel.app.AppViewModel
import com.raman.RollMovie.viewmodel.app.DetailViewModel
import com.raman.RollMovie.viewmodel.favorite.FavoriteViewModel
import com.raman.RollMovie.viewmodel.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    // initialize ViewModels
    private val userViewModel: UserViewModel by viewModels()
    private val appViewModel: AppViewModel by viewModels()
    private val detailViewModel: DetailViewModel by viewModels()
    private val favoriteViewModel: FavoriteViewModel by viewModels()
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RollMovieTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    appViewModel.getRemoteDataMovie()
                    appViewModel.getRemoteDataTvShow()
                    RollMovieUi()
                }
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
                    HomeScreen(appViewModel, myNavController, favoriteViewModel)
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
                SearchScreen(searchViewModel, favoriteViewModel, myNavController)
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
                FavoriteScreen(favoriteViewModel, myNavController)
            }

            composable(
                route = AppScreens.DetailScreen.route + "/" + "{${ApiConstants.AppScreen.KEY_DETAIL_ARG}}" + "/" + "{${ApiConstants.AppScreen.KEY_DETAIL_TYPE_ARG}}",
                arguments = listOf(navArgument(ApiConstants.AppScreen.KEY_DETAIL_ARG) {
                    type = NavType.IntType
                }, navArgument(ApiConstants.AppScreen.KEY_DETAIL_TYPE_ARG) {
                    type = NavType.StringType
                })
            ) {
                DetailScreen(
                    detailViewModel,
                    it.arguments!!.getInt(ApiConstants.AppScreen.KEY_DETAIL_ARG, 154826),
                    it.arguments!!.getString(ApiConstants.AppScreen.KEY_DETAIL_TYPE_ARG, "null"),
                    myNavController,
                    favoriteViewModel
                )
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
                HomeScreen(appViewModel, myNavController, favoriteViewModel)
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