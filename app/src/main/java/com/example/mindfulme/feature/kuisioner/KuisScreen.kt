package com.example.mindfulme.feature.kuisioner

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mindfulme.R
import com.example.mindfulme.feature.main.route.Screen
import com.example.mindfulme.ui.theme.Black1
import com.example.mindfulme.ui.theme.Black4
import com.example.mindfulme.ui.theme.Purple10
import com.example.mindfulme.ui.theme.Purple6

@Composable
fun KuisScreen(navController: NavController) {
    val viewModel : KuisViewModel = viewModel()

    LaunchedEffect(key1 = viewModel.user){
        viewModel.user.value?.let {
            if (it.phqScore.toInt() != -1) {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.KuisScreen.route) {
                        inclusive = true
                    }
                }
            }
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(Black1), contentAlignment = Alignment.Center){
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.kuisioner_gambar),
                contentDescription = "kuis",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.fillMaxWidth(0.9f), contentAlignment = Alignment.Center){
                Text(
                    text = "Kenali kondisi mentalmu",
                    style = MaterialTheme.typography.displaySmall,
                    color = Purple10,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth(0.9f), contentAlignment = Alignment.Center){
                Text(
                    text = "Jawab kuisioner berikut sesuai dengan apa yang kamu rasakan saat ini.",
                    style = MaterialTheme.typography.titleMedium,
                    color = Purple10,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.fillMaxWidth(0.9f), contentAlignment = Alignment.Center){
                Text(
                    text = "Kuisioner berikut adalah Tes PHQ-9 (Patient Health Questionnaire-9), yang bertujuan untuk mengidentifikasi tingkat depresi dan kondisi mentalmu.",
                    style = MaterialTheme.typography.labelSmall,
                    color = Purple10,
                    textAlign = TextAlign.Center

                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(
                        color = Purple6,
                        shape = RoundedCornerShape(100)
                    )
                    .clickable{
                        navController.navigate(Screen.SoalKuis.route) { popUpTo(Screen.KuisScreen.route) { inclusive = true } }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Masuk",
                    color = Black1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}