package com.example.myprojectapp.domain

import com.google.firebase.auth.PhoneAuthProvider

interface AuthInterface {

    fun getVerificationCode(
        phoneNumber: String,
        callBack: PhoneAuthProvider.OnVerificationStateChangedCallbacks,
    )

}