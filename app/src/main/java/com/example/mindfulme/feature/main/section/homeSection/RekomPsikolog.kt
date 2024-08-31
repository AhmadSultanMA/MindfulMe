package com.example.mindfulme.feature.main.section.homeSection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mindfulme.feature.main.components.buttonComp.LihatButton
import com.example.mindfulme.feature.main.components.homeComp.PsikologCard
import com.example.mindfulme.ui.theme.Purple10

@Composable
fun RekomPsikolog(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Rekomendasi Psikolog", style = MaterialTheme.typography.titleLarge, color = Purple10)
            LihatButton(onClick = {})
        }
        Spacer(modifier = Modifier.height(16.dp))
        PsikologCard(navController)
    }
}