package com.example.mindfulme.feature.main.navigation

import com.example.mindfulme.R
import com.example.mindfulme.feature.main.route.Screen

sealed class BottomNavigationItem(
    val route: String,
    val icon: Int,
    val label: String
) {
    object Home: BottomNavigationItem(route = Screen.Home.route, icon = R.drawable.beranda, label = "Beranda")
    object Psikolog: BottomNavigationItem(route = Screen.Psikolog.route, icon = R.drawable.konsultasi, label = "Tes")
    object Cerita: BottomNavigationItem(route = Screen.Cerita.route, icon = R.drawable.cerita, label = "Banding")
    object Profile: BottomNavigationItem(route = Screen.Profile.route, icon = R.drawable.profil, label = "Profil")
}