package com.example.mindfulme.data

import com.example.mindfulme.model.user.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AuthRepository constructor(
    val auth : FirebaseAuth,
    private val firestore : FirebaseFirestore
){
    fun signUp(
        email : String,
        password : String,
        nama: String,
        onSuccess: () -> Unit,
        onFailed: (Exception) -> Unit
    ){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                firestore
                    .collection("user")
                    .document(it.user?.uid ?: "")
                    .set(
                        UserModel(
                            uid = it.user?.uid ?: "",
                            nama = nama,
                            biodata = "",
                            phqScore = -1,
                            premium = false
                        )
                    )
                    .addOnSuccessListener {
                        onSuccess()
                    }
                    .addOnFailureListener {
                        onFailed(it)
                    }
            }
            .addOnFailureListener{
                onFailed(it)
            }
    }

    fun signIn(
        email: String,
        password: String,
        onSuccess: (Boolean) -> Unit,
        onFailed: (Exception) -> Unit
    ){
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                onSuccess(true)
            }
            .addOnFailureListener {
                onFailed(it)
            }
    }

    fun getUser(
        uid: String,
        onSuccess: (UserModel) -> Unit,
        onFailed: (Exception) -> Unit,
    ){
        firestore
            .collection("user")
            .document(uid)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    onFailed(error)
                }
                value?.let { doc ->
                    onSuccess(
                        UserModel(
                            uid = auth?.uid ?: "",
                            nama = doc["nama"] as String,
                            biodata = doc["biodata"] as String,
                            phqScore = doc["phqScore"] as Long,
                            premium = doc["premium"] as Boolean
                        )
                    )
                    return@addSnapshotListener
                }
            }
    }

    fun updateUserPhqScore(
        newPhqScore: Long,
        onSuccess: (Boolean) -> Unit,
        onFailed: (Exception) -> Unit
    ) {
        firestore
            .collection("user")
            .document(auth?.uid?: "")
            .update("phqScore", newPhqScore)
            .addOnSuccessListener {
                onSuccess(true)
            }
            .addOnFailureListener { exception ->
                onFailed(exception)
            }
    }
}