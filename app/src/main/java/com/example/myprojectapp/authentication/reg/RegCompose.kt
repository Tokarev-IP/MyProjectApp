package com.example.myprojectapp.authentication.reg

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myprojectapp.ui.theme.MyProjectAppTheme

class RegCompose {

    private val regComposeItems = RegComposeItems()

    @Composable
    fun FullRegCompose(
        modifier: Modifier = Modifier,
        error: RegErrors,
        onRegAction: (email: String, password: String) -> Unit,
    ) {

        val emailText = rememberSaveable { mutableStateOf("") }
        val password = rememberSaveable { mutableStateOf("") }
        val confirmPassword = rememberSaveable { mutableStateOf("") }

        val isError = rememberSaveable { mutableStateOf(false) }
        val errorText = rememberSaveable { mutableStateOf("") }

        when (error) {
            is RegErrors.NoError -> {
                isError.value = false
                errorText.value = ""
            }
            is RegErrors.RegNewAccountError -> {
                isError.value = true
                errorText.value = error.text
            }
            is RegErrors.RegIsCompleted -> {

            }
        }

        Column(
            modifier = modifier
                .padding(top = 80.dp)
                .width(320.dp)
        ) {
            regComposeItems.Email(
                isError = isError.value,
                onEmail = {
                    emailText.value = it
                },
                emailText = emailText.value,
                errorText = errorText.value
            )
            Spacer(modifier = modifier.height(24.dp))

            regComposeItems.Password(
                onPassword = {
                    password.value = it
                },
                password = password.value,
            )
            Spacer(modifier = modifier.height(24.dp))

            regComposeItems.PasswordConfirm(
                isSamePassword = password.value != confirmPassword.value && password.value.isNotEmpty(),
                onPassword = { confirmPassword.value = it },
                password = confirmPassword.value
            )

            Spacer(modifier = modifier.height(24.dp))

            regComposeItems.RegButton(
                onRegButton = {
                    if (password.value == confirmPassword.value
                        && emailText.value.isNotEmpty()
                        && password.value.isNotEmpty()
                    )
                        onRegAction(emailText.value, password.value)
                }
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyProjectAppTheme {
//            FullRegCompose()
        }
    }
}