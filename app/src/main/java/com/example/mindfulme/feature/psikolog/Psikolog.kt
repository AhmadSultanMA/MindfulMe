package com.example.mindfulme.feature.psikolog

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mindfulme.feature.home.HomeViewModel
import com.example.mindfulme.feature.main.components.psikologComp.PsikologCard
import com.example.mindfulme.feature.main.navigation.BottomNavigationBar
import com.example.mindfulme.ui.theme.Black4
import com.example.mindfulme.ui.theme.Purple10

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Psikolog(navController: NavController) {

    Scaffold(bottomBar = {
        BottomAppBar(
            tonalElevation = 1.dp,
            containerColor = Black4,
        ) {
            BottomNavigationBar(navController = navController)
        }
    }) {
        Box(modifier = Modifier.background(Color.White).padding(16.dp)){
            LazyColumn(modifier = Modifier.fillMaxSize()){
                item {
                    Text(text = "Konsultasi Psikolog", style = MaterialTheme.typography.displaySmall, color = Purple10)
                    Spacer(modifier = Modifier.height(20.dp))
                    PsikologCard(navController)
                    Spacer(modifier = Modifier.height(16.dp))
                    PsikologCard(navController)
                    Spacer(modifier = Modifier.height(16.dp))
                    PsikologCard(navController)
                }
            }
        }
    }
}