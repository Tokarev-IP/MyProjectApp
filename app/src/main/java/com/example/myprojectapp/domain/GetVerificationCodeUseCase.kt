package com.example.myprojectapp.domain

import com.example.myprojectapp.di.MainActivityScope
import com.google.firebase.auth.PhoneAuthProvider
import javax.inject.Inject

//@MainActivityScope
//class GetVerificationCodeUseCase @Inject constructor(private val auth: AuthInterface, authRepository: AuthRepository) {
//
//    fun execute(
//        mobileNumber: String,
//        callBack: PhoneAuthProvider.OnVerificationStateChangedCallbacks
//    ){
//        auth.getVerificationCode(mobileNumber, callBack)
//    }
//}