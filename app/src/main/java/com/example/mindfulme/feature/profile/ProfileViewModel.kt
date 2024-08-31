package com.example.mindfulme.feature.profile

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mindfulme.data.Repository
import com.example.mindfulme.model.cerita.CeritaModel
import com.example.mindfulme.model.user.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ProfileViewModel : ViewModel(){
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    val repository = Repository(auth, firestore)

    val user = mutableStateOf<UserModel?>(null)
    val cerita = mutableStateListOf<CeritaModel>()

    init{
        repository.getUser(
            auth?.uid ?: "",
            onSuccess = {
                user.value = it
            },
            onFailed = {
                Log.e("Gagal", it.toString())
            }
        )

        repository.getAllUserCerita(
            onSuccess = {
                cerita.clear()
                cerita.addAll(it)
            },
            onFailed = {
                Log.e("ERROR", it.toString())
            }
        )

    }
}