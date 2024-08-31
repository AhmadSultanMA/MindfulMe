package com.example.mindfulme.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mindfulme.feature.bacaCerita.BacaCerita
import com.example.mindfulme.feature.buatCerita.BuatCerita
import com.example.mindfulme.feature.cerita.Cerita
import com.example.mindfulme.feature.ceritaKu.CeritaKu
import com.example.mindfulme.feature.changePass.ChangePass
import com.example.mindfulme.feature.forgotPass.ForgotPass
import com.example.mindfulme.feature.home.Home
import com.example.mindfulme.feature.kuisioner.HasilKuis
import com.example.mindfulme.feature.kuisioner.KuisScreen
import com.example.mindfulme.feature.kuisioner.SoalKuis
import com.example.mindfulme.feature.main.route.Screen
import com.example.mindfulme.feature.notification.Notification
import com.example.mindfulme.feature.onBoard.OnBoard
import com.example.mindfulme.feature.otp.Otp
import com.example.mindfulme.feature.profile.Profile
import com.example.mindfulme.feature.psikolog.Psikolog
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

        composable(route = Screen.Cerita.route) {
            Cerita(navController = navController)
        }

        composable(route = "${Screen.BacaCerita.route}/{cerita_id}",
            arguments = listOf(
                navArgument("cerita_id") {
                    type = NavType.StringType
                }
        ))
        {
            val cerita_id = it.arguments?.getString("cerita_id") ?: ""
            BacaCerita(navController = navController, cerita_id)
        }

        composable(route = Screen.SoalKuis.route) {
            SoalKuis(navController = navController)
        }

        composable(route = Screen.KuisScreen.route) {
            KuisScreen(navController = navController)
        }

        composable(route = Screen.HasilKuis.route) {
            HasilKuis(navController = navController)
        }

        composable(route = Screen.BuatCerita.route) {
            BuatCerita(navController = navController)
        }

        composable(route = Screen.CeritaKu.route) {
            CeritaKu(navController = navController)
        }

        composable(route = Screen.Profile.route) {
            Profile(navController = navController)
        }

        composable(route = Screen.Psikolog.route) {
            Psikolog(navController = navController)
        }
    }
}