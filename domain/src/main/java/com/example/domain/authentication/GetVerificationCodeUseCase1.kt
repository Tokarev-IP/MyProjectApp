package com.example.domain.authentication

import com.example.domain.AuthInterface1
import com.google.firebase.auth.PhoneAuthProvider

class GetVerificationCodeUseCase1 (private val auth: AuthInterface1) {

    fun execute(
        mobileNumber: String,
        callBack: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    ){
        auth.getVerificationCode(mobileNumber, callBack)
    }
}