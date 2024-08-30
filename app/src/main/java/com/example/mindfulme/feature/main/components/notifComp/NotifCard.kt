package com.example.mindfulme.feature.main.components.notifComp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mindfulme.feature.main.route.Screen
import com.example.mindfulme.ui.theme.Black1
import com.example.mindfulme.ui.theme.Blue4
import com.example.mindfulme.ui.theme.Purple1
import com.example.mindfulme.ui.theme.Purple10
import com.example.mindfulme.ui.theme.Purple9

@Composable
fun NotifCard() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(55.dp)
                .background(Blue4, shape = CircleShape),
            contentAlignment = Alignment.Center,
            content = {
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector =  Icons.Outlined.Book,
                    contentDescription = "iconBook",
                    tint = Black1
                )
            }
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = "Cerita Inspiratif Menanti",
                style = MaterialTheme.typography.titleLarge,
                color = Purple10
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Ada cerita baru yang mungkin bisa menginspirasimu. Yuk, baca sekarang!",
                style = MaterialTheme.typography.labelSmall,
                color = Purple10
            )
        }
    }
}