package com.raman.RollMovie.utils

sealed class AppScreens(val route :String) {

    data object MainScreen :AppScreens("MainScreens")
    data object SignUpScreen :AppScreens("SignUpScreen")
    data object SignInScreen :AppScreens("SignInScreen")
    data object ProfileScreen :AppScreens("ProfileScreen")
    data object EditProfileScreen :AppScreens("EditProfileScreen")
    data object SearchScreen :AppScreens("SearchScreen")
    data object DetailScreen :AppScreens("DetailScreen")
    data object FavoriteScreen :AppScreens("FavoriteScreen")
    data object SettingScreen :AppScreens("SettingScreen")

}
