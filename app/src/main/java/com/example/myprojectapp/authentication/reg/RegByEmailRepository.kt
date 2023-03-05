package com.example.myprojectapp.authentication.reg

import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class RegByEmailRepository {

    private val auth = FirebaseAuth.getInstance()
    fun createNewAccount(
        email: String,
        password: String,
        onError: (RegErrors) -> Unit,
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.i("REG", "registration is success")
                    onError(RegErrors.NoError)
                }
            }
            .addOnFailureListener {
                Log.i("REGERROR", it.toString() + it.cause.toString())
                onError(
                    RegErrors.RegNewAccountError(it.message ?: ""),
                )
            }
    }

    fun signIn(
        email: String,
        password: String,
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    auth.currentUser?.let {
                    }
                }
            }
    }
}