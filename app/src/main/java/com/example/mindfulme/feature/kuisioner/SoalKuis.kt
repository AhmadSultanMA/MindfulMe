package com.example.mindfulme.feature.kuisioner

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mindfulme.feature.main.components.kuisComp.JawabanButton
import com.example.mindfulme.feature.main.route.Screen
import com.example.mindfulme.feature.onBoard.RoundedProgressIndicator
import com.example.mindfulme.ui.theme.Black1
import com.example.mindfulme.ui.theme.Black5
import com.example.mindfulme.ui.theme.Purple10
import com.example.mindfulme.ui.theme.Purple6
import com.example.mindfulme.ui.theme.Purple9

@Composable
fun SoalKuis(navController: NavController) {
    val viewModel : KuisViewModel = viewModel()

    val soalSortedByNomor = viewModel.kuisData.sortedBy { it.nomor }

    LaunchedEffect(key1 = viewModel.isDone.value){
        if(viewModel.isDone.value == true){
            navController.navigate(Screen.HasilKuis.route) {
                popUpTo(Screen.SoalKuis.route) {
                    inclusive = true
                }
            }
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(Black1))
    {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Kuisioner",
                style = MaterialTheme.typography.displaySmall,
                color = Purple10
            )
            Spacer(modifier = Modifier.height(16.dp))
            RoundedProgressIndicator(
                progress = (viewModel.nomor.value.toFloat()) / 9,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd){
                Text(text = "Pertanyaan " + viewModel.nomor.value.toString() + " dari 9", style = MaterialTheme.typography.bodyLarge, color = Purple9)
            }
            Spacer(modifier = Modifier.height(60.dp))
            Text(text = "Apakah kamu", style = MaterialTheme.typography.displaySmall, color = Purple10)
            Text(text = soalSortedByNomor[viewModel.nomor.value.toInt()-1].soal)
            Spacer(modifier = Modifier.height(36.dp))

            JawabanButton(text = "Hampir setiap hari", bobotSoal = soalSortedByNomor[viewModel.nomor.value.toInt()-1].jawab_d, bobotJawaban = viewModel.mapJawaban[viewModel.nomor.value.toInt()-1].value, onJawabChange = {
                viewModel.mapJawaban[viewModel.nomor.value.toInt() - 1].value = it ?: -1
            })
            Spacer(modifier = Modifier.height(16.dp))

            JawabanButton(text = "Lebih dari setengah hari", bobotSoal = soalSortedByNomor[viewModel.nomor.value.toInt()-1].jawab_c, bobotJawaban = viewModel.mapJawaban[viewModel.nomor.value.toInt()-1].value, onJawabChange = {
                viewModel.mapJawaban[viewModel.nomor.value.toInt() - 1].value = it ?: -1
            })
            Spacer(modifier = Modifier.height(16.dp))

            JawabanButton(text = "Beberapa hari", bobotSoal = soalSortedByNomor[viewModel.nomor.value.toInt()-1].jawab_b, bobotJawaban = viewModel.mapJawaban[viewModel.nomor.value.toInt()-1].value, onJawabChange = {
                viewModel.mapJawaban[viewModel.nomor.value.toInt() - 1].value = it ?: -1
            })
            Spacer(modifier = Modifier.height(16.dp))

            JawabanButton(text = "Tidak sama sekali", bobotSoal = soalSortedByNomor[viewModel.nomor.value.toInt()-1].jawab_a, bobotJawaban = viewModel.mapJawaban[viewModel.nomor.value.toInt()-1].value, onJawabChange = {
                viewModel.mapJawaban[viewModel.nomor.value.toInt() - 1].value = it ?: -1
            })
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Purple6, shape = RoundedCornerShape(20))
                        .clickable
                        {
                            if (viewModel.nomor.value > 0) {
                                viewModel.nomor.value -= 1
                            }
                        }
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        text = "Sebelumnya", style = MaterialTheme.typography.labelMedium,
                        color = Black1
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .background(color = if (viewModel.mapJawaban[viewModel.nomor.value.toInt()-1].value.toInt() == -1) Black5 else Purple6, shape = RoundedCornerShape(20))
                        .clickable
                        {
                            if (viewModel.nomor.value < soalSortedByNomor.size) {
                                if (viewModel.mapJawaban[viewModel.nomor.value.toInt()-1].value.toInt() != -1){
                                    viewModel.nomor.value += 1
                                }
                            } else if (viewModel.nomor.value.toInt() == soalSortedByNomor.size) {
                                if (viewModel.mapJawaban[viewModel.nomor.value.toInt()-1].value.toInt() != -1){
                                    viewModel.updatePhq(
                                        viewModel.mapJawaban.sumOf { it.value }
                                    )
                                }
                            }
                        }
                ) {
                    if (viewModel.nomor.value.toInt() == soalSortedByNomor.size){
                        Text(
                            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                            text = "Selesai", style = MaterialTheme.typography.labelMedium,
                            color = Color.White
                        )
                    }else{
                        Text(
                            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                            text = "Selanjutnya", style = MaterialTheme.typography.labelMedium,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}