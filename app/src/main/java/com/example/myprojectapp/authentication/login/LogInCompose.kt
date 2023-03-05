package com.example.myprojectapp.authentication.login

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class LogInCompose() {

    private val logInComposeItem = LogInComposeItems()

    @Composable
    fun LogIn(
        modifier: Modifier = Modifier,
        onLogIn:(emailMobile: String, password: String) -> Unit,
        errors: LogInErrors,
    ) {
        val emailMobileText = rememberSaveable { mutableStateOf("") }
        val passwordText = rememberSaveable { mutableStateOf("") }

        val isError = rememberSaveable { mutableStateOf(false) }
        val errorText = rememberSaveable { mutableStateOf("") }

        when (errors){
            is LogInErrors.NoError -> {
                isError.value = false
                errorText.value = ""
            }
            is LogInErrors.LogInError -> {
                isError.value = true
                errorText.value = errors.text
            }
            is LogInErrors.LogInIsCompleted -> {

            }
        }

        Column(
            modifier = modifier
                .padding(top = 80.dp)
                .width(320.dp),
        ) {
            logInComposeItem.EmailOrMobile(
                isError = isError.value,
                text = emailMobileText.value,
                onText = {
                    emailMobileText.value = it
                },
                errorText = errorText.value
            )

            Spacer(modifier = modifier.height(24.dp))

            logInComposeItem.Password(
                onPassword = {
                    passwordText.value = it
                },
                password = passwordText.value,
                isError = isError.value,
                errorText = errorText.value
            )

            Spacer(modifier = modifier.height(24.dp))

            logInComposeItem.LogInButton(
                onLogInButton = {
                    onLogIn(emailMobileText.value, passwordText.value)
                },
                isEnabled = emailMobileText.value.isNotEmpty() && passwordText.value.isNotEmpty()
            )
        }
    }
}