package com.example.mindfulme.feature.cerita

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CeritaViewModel: ViewModel() {
    val isSelected = mutableStateOf("All")
}