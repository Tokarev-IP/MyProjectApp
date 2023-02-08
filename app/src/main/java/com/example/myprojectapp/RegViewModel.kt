package com.example.myprojectapp

import androidx.lifecycle.ViewModel
import com.example.myprojectapp.registration.RegByEmailRepository
import com.example.myprojectapp.registration.RegErrors
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegViewModel: ViewModel() {

    private val regServerError: MutableStateFlow<RegErrors> = MutableStateFlow(RegErrors.NoError)
    val state = regServerError.asStateFlow()

    fun regByEmail(email: String, password: String) {
        RegByEmailRepository().createNewAccount(
            email,
            password,
            onError = { error: RegErrors->
                regServerError.value = error
            }
        )
    }
}