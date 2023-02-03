package com.mygaurdian.android.ui.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mygaurdian.android.ui.screens.AllSetScreen
import com.mygaurdian.android.ui.screens.LoginScreen
import com.mygaurdian.android.ui.screens.PermissionScreen
import com.mygaurdian.android.ui.screens.SignUpScreen

@Composable
fun SetupNavGraph(navController : NavHostController){

    NavHost(navController = navController, startDestination = Screen.LoginScreen.route){
        composable(route = Screen.LoginScreen.route){
            LoginScreen()
        }
        composable(route = Screen.PermissionScreen.route){
            PermissionScreen(navController)
        }
        composable(route = Screen.SignUpScreen.route){
            SignUpScreen(navController)
        }
        composable(route = Screen.AllSetScreen.route){
            AllSetScreen()
        }
    }

}