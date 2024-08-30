package com.example.mindfulme.feature.main.components.ceritaComp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mindfulme.R
import com.example.mindfulme.feature.main.route.Screen
import com.example.mindfulme.ui.theme.Black1
import com.example.mindfulme.ui.theme.Purple10
import com.example.mindfulme.ui.theme.Purple9

@Composable
fun CeritaCard(navController: NavController) {
    Box(modifier = Modifier
        .background(color = Black1, shape = RoundedCornerShape(12.dp))
        .padding(16.dp)
        .clickable {
            navController.navigate(Screen.BacaCerita.route) { popUpTo(Screen.Cerita.route) { inclusive = true } }
        }){
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(id = R.drawable.profile), contentDescription = "profile", modifier = Modifier.size(30.dp))
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Jessicca", style = MaterialTheme.typography.titleLarge, color = Purple10)
                }
                Box(modifier = Modifier
                    .background(color = Black1, shape = RoundedCornerShape(100))
                    .border(1.dp, color = Purple9, shape = RoundedCornerShape(100))
                    .padding(horizontal = 8.dp, vertical = 2.dp))
                {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.size(18.dp),
                            imageVector =  Icons.Outlined.Edit,
                            contentDescription = "iconPen",
                            tint = Purple9
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Edit cerita", style = MaterialTheme.typography.titleSmall, color = Purple10)
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.gambar_cerita),
                contentDescription = "gambar",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxSize()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Melawan Badai Dalam Diri",
                style = MaterialTheme.typography.titleMedium,
                color = Purple10
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "“Doing some yoga with my friend at the beach. You should do it because it’s good for your body and your baby.”",
                style = MaterialTheme.typography.bodyMedium,
                color = Purple10
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "1 jam lalu", style = MaterialTheme.typography.bodySmall, color = Purple10)
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.size(15.dp),
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "iconLove",
                            tint = Purple10
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(text = "5126", style = MaterialTheme.typography.labelSmall, color = Purple10)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.size(15.dp),
                            imageVector = Icons.Outlined.Comment,
                            contentDescription = "iconComment",
                            tint = Purple10
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(text = "5126", style = MaterialTheme.typography.labelSmall, color = Purple10)
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.size(15.dp),
                            imageVector = Icons.Outlined.BookmarkBorder,
                            contentDescription = "iconBookmark",
                            tint = Purple10
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(text = "5126", style = MaterialTheme.typography.labelSmall, color = Purple10)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        modifier = Modifier.size(15.dp),
                        imageVector = Icons.Outlined.Share,
                        contentDescription = "iconShare",
                        tint = Purple10
                    )
                }
            }
        }
    }
}