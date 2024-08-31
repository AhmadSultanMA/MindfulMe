package com.example.mindfulme.model.cerita

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class CeritaModel(
    val gambar: String = "",
    val penulis: String = "",
    val id: String = "",
    val isi: String = "",
    val judul: String = "",
    val kategori: List<String> = listOf(""),
    val user_id: String = ""
)
