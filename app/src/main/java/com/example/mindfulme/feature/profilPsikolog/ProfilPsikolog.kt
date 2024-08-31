package com.example.mindfulme.feature.profilPsikolog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mindfulme.R
import com.example.mindfulme.feature.main.components.buttonComp.BackPage
import com.example.mindfulme.feature.main.route.Screen
import com.example.mindfulme.ui.theme.Black1
import com.example.mindfulme.ui.theme.Black6
import com.example.mindfulme.ui.theme.Purple10
import com.example.mindfulme.ui.theme.Purple6

@Composable
fun ProfilPsikolog(navController: NavController) {
    Box(modifier = Modifier
        .background(Color.White)
        .padding(16.dp)){
        LazyColumn(modifier = Modifier.fillMaxSize()){
            item {
                BackPage(onClick = {
                    navController.navigate(Screen.Psikolog.route) {
                        popUpTo(Screen.ProfilPsikolog.route) {
                            inclusive = true
                        }
                } }, text = "Profil Psikolog")
                Spacer(modifier = Modifier.height(36.dp))
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                    Image(painter = painterResource(id = R.drawable.psikolog), contentDescription = "psikolog", modifier = Modifier.size(70.dp))
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Dr. Phos Gray", style = MaterialTheme.typography.headlineSmall, color = Purple10)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Psikologi Klinis Dewasa", style = MaterialTheme.typography.titleMedium, color = Black6)
                    Spacer(modifier = Modifier.height(36.dp))
                }
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Column(Modifier.fillMaxWidth(0.9f)) {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(painter = painterResource(id = R.drawable.pengalaman), contentDescription = "ic_pengalaman", modifier = Modifier.size(36.dp))
                                Spacer(modifier = Modifier.width(5.dp))
                                Column {
                                    Text(text = "Pengalaman", style = MaterialTheme.typography.labelSmall, color = Purple10)
                                    Text(text = "5 Tahun", style = MaterialTheme.typography.titleMedium, color = Purple10)
                                }
                            }
                            Column {
                                Text(text = "Ulasan", style = MaterialTheme.typography.labelSmall, color = Purple10)
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
                            }
                        }
                        Spacer(modifier = Modifier.height(36.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(painter = painterResource(id = R.drawable.lokasi), contentDescription = "ic_pengalaman", modifier = Modifier.size(36.dp))
                            Spacer(modifier = Modifier.width(5.dp))
                            Column {
                                Text(text = "Lokasi Praktik", style = MaterialTheme.typography.labelSmall, color = Purple10)
                                Text(text = "Psikologi Malang Holistic Consultan", style = MaterialTheme.typography.titleMedium, color = Purple10)
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(painter = painterResource(id = R.drawable.alumnus), contentDescription = "ic_pengalaman", modifier = Modifier.size(36.dp))
                            Spacer(modifier = Modifier.width(5.dp))
                            Column {
                                Text(text = "Alumnus", style = MaterialTheme.typography.labelSmall, color = Purple10)
                                Text(text = "Universitas Brawijaya, 2013", style = MaterialTheme.typography.titleMedium, color = Purple10)
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(painter = painterResource(id = R.drawable.registrasi), contentDescription = "ic_pengalaman", modifier = Modifier.size(36.dp))
                            Spacer(modifier = Modifier.width(5.dp))
                            Column {
                                Text(text = "Nomor Surat Tanda Registrasi", style = MaterialTheme.typography.labelSmall, color = Purple10)
                                Text(text = "123456789-4567891", style = MaterialTheme.typography.titleMedium, color = Purple10)
                            }
                        }
                        Spacer(modifier = Modifier.height(36.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Purple6, shape = RoundedCornerShape(100))
                                .padding(vertical = 10.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_chat),
                                    contentDescription = "iconchat",
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = "Chat",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Black1
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}