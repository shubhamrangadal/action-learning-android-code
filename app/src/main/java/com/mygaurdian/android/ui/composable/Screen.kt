package com.mygaurdian.android.ui.composable

sealed class Screen(val route: String){
    object AllSetScreen: Screen(route = "all_set_screen")
    object LoginScreen: Screen(route = "login_screen")
    object PermissionScreen: Screen(route = "permission_screen")
    object SignUpScreen: Screen(route = "sign_up_screen")
}
