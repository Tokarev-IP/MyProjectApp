package com.example.myprojectapp.authentication

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myprojectapp.authentication.login.LogInErrors
import com.example.myprojectapp.authentication.reg.RegErrors
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel: ViewModel() {

//    private val auth: AuthInterface = AuthRepository(this)
//    private val authUseCase = GetVerificationCodeUseCase(auth)

    private val regServerError: MutableStateFlow<RegErrors> = MutableStateFlow(RegErrors.NoError)
    val stateReg = regServerError.asStateFlow()

    private val logInServerError: MutableStateFlow<LogInErrors> = MutableStateFlow(LogInErrors.NoError)
    val stateLogIn = logInServerError.asStateFlow()

    fun setAuthActions(events: Events){
        when (events){
            is Events.GetVerificationCode -> {

            }
            is Events.SendVerificationCode -> {

            }
            else -> {}
        }
    }

//    fun getVerificationCode(getVerificationCodeUseCase: GetVerificationCodeUseCase, string: String) {
//        getVerificationCodeUseCase.execute(string, getCallback())
//    }

    private fun getCallback(): PhoneAuthProvider.OnVerificationStateChangedCallbacks {
        return object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Log.d("TAG", "onVerificationCompleted:$credential")
//                signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.
                Log.w("TAG", "onVerificationFailed", e)

                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                } else if (e is FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                } else if (e is FirebaseNetworkException) {

                }

                // Show a message and update the UI
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {

            }

        }
    }

}