package com.example.mindfulme.feature.main.components.psikologComp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mindfulme.R
import com.example.mindfulme.ui.theme.Black1
import com.example.mindfulme.ui.theme.Black6
import com.example.mindfulme.ui.theme.Green7
import com.example.mindfulme.ui.theme.Purple1
import com.example.mindfulme.ui.theme.Purple10
import com.example.mindfulme.ui.theme.Purple6

@Composable
fun PsikologCard() {
    Box(
        modifier = Modifier
            .height(130.dp)
            .fillMaxWidth()
            .background(color = Purple1, shape = RoundedCornerShape(20))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(id = R.drawable.psikolog),
                contentDescription = "psikolog",
                modifier = Modifier
                    .fillMaxWidth(0.35f)
                    .fillMaxHeight(0.8f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Dr. Phos Gray",
                    style = MaterialTheme.typography.titleMedium,
                    color = Purple10
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Berpengalaman 5 tahun",
                    style = MaterialTheme.typography.labelSmall,
                    color = Black6
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.star5),
                        contentDescription = "star5",
                        modifier = Modifier.width(60.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "5.0 (3.422)",
                        style = MaterialTheme.typography.labelSmall,
                        color = Black6
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Online", style = MaterialTheme.typography.labelSmall, color = Green7)
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier
                        .background(color = Purple6, shape = RoundedCornerShape(100))
                        .padding(horizontal = 10.dp, vertical = 3.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_chat),
                            contentDescription = "iconchat",
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Chat Sekarang",
                            style = MaterialTheme.typography.bodySmall,
                            color = Black1
                        )
                    }
                }
            }
        }
    }
}