package com.example.mindfulme.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mindfulme.feature.changePass.ChangePass
import com.example.mindfulme.feature.forgotPass.ForgotPass
import com.example.mindfulme.feature.home.Home
import com.example.mindfulme.feature.main.route.Screen
import com.example.mindfulme.feature.notification.Notification
import com.example.mindfulme.feature.onBoard.OnBoard
import com.example.mindfulme.feature.otp.Otp
import com.example.mindfulme.feature.signIn.SignIn
import com.example.mindfulme.feature.signUp.SignUp
import com.example.mindfulme.feature.splash.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =  Screen.Splash.route) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.OnBoard.route) {
            OnBoard(navController = navController)
        }

        composable(route = Screen.SignIn.route) {
            SignIn(navController = navController)
        }

        composable(route = Screen.SignUp.route) {
            SignUp(navController = navController)
        }

        composable(route = Screen.ForgotPass.route) {
            ForgotPass(navController = navController)
        }

        composable(route = Screen.ChangePass.route) {
            ChangePass(navController = navController)
        }

        composable(route = Screen.Otp.route) {
            Otp(navController = navController)
        }

        composable(route = Screen.Home.route) {
            Home(navController = navController)
        }

        composable(route = Screen.Notification.route) {
            Notification(navController = navController)
        }
    }
}