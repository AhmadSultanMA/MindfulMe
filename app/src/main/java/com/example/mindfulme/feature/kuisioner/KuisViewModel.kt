package com.example.mindfulme.feature.kuisioner

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mindfulme.data.AuthRepository
import com.example.mindfulme.model.kuis.KuisModel
import com.example.mindfulme.model.user.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class KuisViewModel : ViewModel() {
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val authRepository = AuthRepository(auth, firestore)

    val nomor = mutableLongStateOf(1)
    val mapJawaban = mutableListOf<MutableState<Long>>()
    val isDone = mutableStateOf(false)
    val user = mutableStateOf<UserModel?>(null)

    init{
        authRepository.getUser(
            auth?.uid ?: "",
            onSuccess = {
                user.value = it
            },
            onFailed = {
                Log.e("Gagal", it.toString())
            }
        )
    }

    fun updatePhq(
        phqScore: Long
    ){
        isDone.value = false
        authRepository.updateUserPhqScore(
            phqScore,
            onSuccess = {
                isDone.value = it
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )
    }

    val kuisData = listOf(
        KuisModel(
            nomor = 1,
            soal = "Tidak Menyukai atau Merasa Gembira Melakukan Hal-Hal",
            jawab_a = 0,
            jawab_b = 1,
            jawab_c = 2,
            jawab_d = 3
        ),
        KuisModel(
            nomor = 2,
            soal = "Merasa Sedih, Depresi, atau Tanpa Harapan",
            jawab_a = 0,  // Tidak sama sekali
            jawab_b = 1,  // Beberapa hari
            jawab_c = 2,  // Lebih dari setengah hari
            jawab_d = 3   // Hampir setiap hari
        ),
        KuisModel(
            nomor = 3,
            soal = "Sulit Tidur atau Terus Bangun Malam",
            jawab_a = 0,  // Tidak sama sekali
            jawab_b = 1,  // Beberapa hari
            jawab_c = 2,  // Lebih dari setengah hari
            jawab_d = 3   // Hampir setiap hari
        ),
        KuisModel(
            nomor = 4,
            soal = "Merasa Tidak Berenergi atau Tidak Suka Beraktivitas",
            jawab_a = 0,  // Tidak sama sekali
            jawab_b = 1,  // Beberapa hari
            jawab_c = 2,  // Lebih dari setengah hari
            jawab_d = 3   // Hampir setiap hari
        ),
        KuisModel(
            nomor = 5,
            soal = "Makan Terlalu Sedikit atau Terlalu Banyak Makan",
            jawab_a = 0,  // Tidak sama sekali
            jawab_b = 1,  // Beberapa hari
            jawab_c = 2,  // Lebih dari setengah hari
            jawab_d = 3   // Hampir setiap hari
        ),
        KuisModel(
            nomor = 6,
            soal = "Merasa Buruk tentang Diri Sendiri – Atau Merasa Gagal atau Telah Mengkhianati Diri Sendiri atau Keluarga",
            jawab_a = 0,  // Tidak sama sekali
            jawab_b = 1,  // Beberapa hari
            jawab_c = 2,  // Lebih dari setengah hari
            jawab_d = 3   // Hampir setiap hari
        ),
        KuisModel(
            nomor = 7,
            soal = "Sulit Fokus Pada Hal-Hal, Seperti Membaca Koran atau Menonton TV",
            jawab_a = 0,  // Tidak sama sekali
            jawab_b = 1,  // Beberapa hari
            jawab_c = 2,  // Lebih dari setengah hari
            jawab_d = 3   // Hampir setiap hari
        ),
        KuisModel(
            nomor = 8,
            soal = "Bergerak atau Berbicara dengan Perlahan sehingga Orang Lain Bisa Melihatnya. Atau Sebaliknya – Selalu Bergerak atau Berbicara dengan Cepat sehingga Orang Lain Bisa Melihatnya",
            jawab_a = 0,  // Tidak sama sekali
            jawab_b = 1,  // Beberapa hari
            jawab_c = 2,  // Lebih dari setengah hari
            jawab_d = 3   // Hampir setiap hari
        ),
        KuisModel(
            nomor = 9,
            soal = "Pikiran bahwa Lebih Baik Mati atau Menghancurkan Diri Sendiri dalam Cara Lain",
            jawab_a = 0,  // Tidak sama sekali
            jawab_b = 1,  // Beberapa hari
            jawab_c = 2,  // Lebih dari setengah hari
            jawab_d = 3   // Hampir setiap hari
        )
    )

    init {
        kuisData.forEach { _ ->
            mapJawaban.add(mutableStateOf(-1L))
        }
    }
}