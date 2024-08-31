package com.example.mindfulme.feature.jurnal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mindfulme.ui.theme.Black1
import com.example.mindfulme.ui.theme.Purple10

@Composable
fun JurnalHarian() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Black1)
        .padding(16.dp))
    {
        Text(text = "Jurnal Harian", style = MaterialTheme.typography.displayMedium, color = Purple10)
    }
}