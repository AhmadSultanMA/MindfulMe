package com.example.mindfulme.feature.main.route

sealed class Screen(val route: String){
    object Splash : Screen("splash")
    object Home : Screen("home")
    object OnBoard : Screen("onBoard")
    object SignIn : Screen("signIn")
    object SignUp : Screen("signUp")
    object ForgotPass : Screen("forgotPass")
    object ChangePass : Screen("changePass")
    object Otp : Screen("otp")
    object Notification : Screen("notification")
}