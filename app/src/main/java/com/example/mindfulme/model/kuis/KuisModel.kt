package com.example.mindfulme.model.kuis

data class KuisModel (
    val nomor : Long,
    val soal : String,
    val jawab_a : Long,
    val jawab_b : Long,
    val jawab_c : Long,
    val jawab_d : Long,
)