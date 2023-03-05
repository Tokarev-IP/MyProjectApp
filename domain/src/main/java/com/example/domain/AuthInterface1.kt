package com.example.domain

import com.google.firebase.auth.PhoneAuthProvider

interface AuthInterface1 {
    fun getVerificationCode(
        phoneNumber: String,
        callBack: PhoneAuthProvider.OnVerificationStateChangedCallbacks,
    )
}