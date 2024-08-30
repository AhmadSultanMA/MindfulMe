package com.example.mindfulme.feature.main.components.kuisComp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mindfulme.ui.theme.Black1
import com.example.mindfulme.ui.theme.Purple6

@Composable
fun JawabanButton(text: String, bobotSoal: Long, bobotJawaban: Long, onJawabChange:(Long?)->Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .border(1.dp, color = Purple6, shape = RoundedCornerShape(100))
        .background(color = if(bobotSoal == bobotJawaban) Purple6 else Black1, shape = RoundedCornerShape(100))
        .padding(vertical = 18.dp)
        .clickable {
            onJawabChange(bobotSoal)
        }, contentAlignment = Alignment.Center)
    {
        Text(text = text, style = MaterialTheme.typography.bodySmall, color = if(bobotSoal == bobotJawaban) Black1 else Purple6)
    }
}