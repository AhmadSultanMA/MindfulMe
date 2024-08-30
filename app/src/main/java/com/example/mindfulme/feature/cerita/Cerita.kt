package com.example.mindfulme.feature.cerita

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mindfulme.feature.main.components.ceritaComp.CeritaCard
import com.example.mindfulme.feature.main.navigation.BottomNavigationBar
import com.example.mindfulme.feature.main.section.ceritaSection.AppBar
import com.example.mindfulme.ui.theme.Black1
import com.example.mindfulme.ui.theme.Purple3
import com.example.mindfulme.ui.theme.Purple6

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cerita(navController: NavController) {
    val viewModel : CeritaViewModel = viewModel()

    val categories = listOf(
        "All", "Romantis", "Keluarga", "Karir", "Hubungan",
        "Finansial", "Makanan", "Pendidikan", "Inspirasi",
        "Psikologi", "Fantasi", "Lainnya"
    )

    Scaffold(bottomBar = {
        BottomAppBar(
            tonalElevation = 8.dp,
            containerColor = Color.White,
        ) {
            BottomNavigationBar(navController = navController)
        }
    }) {
        Box(modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Purple3, Color.White)
                )
            )
            .padding(16.dp)){
            LazyColumn(modifier = Modifier.fillMaxSize()){
                item {
                    AppBar()
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(categories) { category ->
                            CategoryChip(
                                text = category,
                                isSelected = category == viewModel.isSelected.value,
                                viewModel = viewModel
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    CeritaCard(navController = navController)
                }
            }
        }
    }
}

@Composable
fun CategoryChip(text: String, isSelected: Boolean, viewModel: CeritaViewModel) {
    val backgroundColor = if (isSelected) Purple6 else Black1
    val textColor = if (isSelected) Black1 else Purple6

    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(100)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
                viewModel.isSelected.value = text
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.titleSmall
        )
    }
}