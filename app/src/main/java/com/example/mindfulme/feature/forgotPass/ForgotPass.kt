package com.example.mindfulme.feature.forgotPass

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mindfulme.ui.theme.Black5
import com.example.mindfulme.ui.theme.Black7
import com.example.mindfulme.ui.theme.Black8

@Composable
fun ForgotPass(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = "Lupa Kata Sandi?", style = MaterialTheme.typography.displayMedium, color = Black8)
        Text(text = "Silakan masukkan alamat email Anda untuk menerima kartu verifikasi.", style = MaterialTheme.typography.bodySmall, color = Black7)
        Spacer(modifier = Modifier.height(12.dp))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Black5)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Alamat Email", style = MaterialTheme.typography.bodyLarge, color = Black8)
    }
}