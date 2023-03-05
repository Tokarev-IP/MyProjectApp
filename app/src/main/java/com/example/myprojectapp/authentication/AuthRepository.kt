package com.example.myprojectapp.authentication

import android.util.Log
import com.example.myprojectapp.MainActivity
import com.example.myprojectapp.di.MainActivityScope
import com.example.myprojectapp.domain.AuthInterface
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton
//class AuthRepository @Inject constructor(private val activity: MainActivity, string: String) : AuthInterface {
//    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
//    val a = string
//
//    override fun getVerificationCode(
//        phoneNumber: String,
//        callBack: PhoneAuthProvider.OnVerificationStateChangedCallbacks,
//    ) {
//        val options = PhoneAuthOptions.newBuilder(auth)
//            .setPhoneNumber(phoneNumber)                  // Phone number to verify
//            .setTimeout(120L, TimeUnit.SECONDS)    // Timeout and unit
//            .setActivity(activity)                        // Activity (for callback binding)
//            .setCallbacks(callBack)                       // OnVerificationStateChangedCallbacks
//            .build()
//
//        PhoneAuthProvider.verifyPhoneNumber(options)
//    }
//
//    private fun signInWithPhoneAuthCredential(
//        credential: PhoneAuthCredential,
//    ) {
//        auth.signInWithCredential(credential)
//            .addOnCompleteListener(activity) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d("TAG", "signInWithCredential:success")
//
//                    val user = task.result?.user
//                } else {
//                    // Sign in failed, display a message and update the UI
//                    Log.w("TAG", "signInWithCredential:failure", task.exception)
//                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
//                        // The verification code entered was invalid
//                    }
//                    // Update UI
//                }
//            }
//    }
//
//    private fun setCredential(
//        verificationId: String,
//        code: String,
//    ) {
//        val credential = PhoneAuthProvider.getCredential(verificationId, code)
//    }
//
//
//}