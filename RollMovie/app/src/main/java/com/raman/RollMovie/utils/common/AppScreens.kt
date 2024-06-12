package com.raman.RollMovie.utils.common

sealed class AppScreens(val route :String) {

    data object MainScreen : AppScreens("MainScreens")
    data object SignUpScreen : AppScreens("SignUpScreen")
    data object SignInScreen : AppScreens("SignInScreen")
    data object SeeAllScreen : AppScreens("SeeAllScreen")
    data object SearchScreen : AppScreens("SearchScreen")
    data object DetailScreen : AppScreens("DetailScreen")
    data object FavoriteScreen : AppScreens("FavoriteScreen")
    data object SettingScreen : AppScreens("SettingScreen")
    data object HomeScreen : AppScreens("HomeScreen")

}
