package com.example.myprojectapp.registration

import android.view.WindowManager
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myprojectapp.MainActivity
import com.example.myprojectapp.ui.theme.MyProjectAppTheme

class RegCompose {

    private val regComposeItems = RegComposeItems()

    @Composable
    fun FullRegCompose(
        modifier: Modifier = Modifier,
        error: Boolean,
        onRegAction: (email: String, password: String) -> Unit,
        onLogInAction: () -> Unit,
    ) {
        val isRegistration = rememberSaveable { mutableStateOf(false) }
        val isError = rememberSaveable { mutableStateOf(false) }
        val password = rememberSaveable { mutableStateOf("") }
        val confirmPassword = rememberSaveable { mutableStateOf("") }
        val emailText = rememberSaveable { mutableStateOf("") }

        isError.value = error

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(top = 80.dp)
                .width(320.dp)
        ) {
            regComposeItems.Email(
                isError = isError.value,
                onEmail = {
                    emailText.value = it
                },
                emailText = emailText.value
            )
            Spacer(modifier = modifier.height(24.dp))

            regComposeItems.Password(
                isError = isError.value,
                onPassword = {
                    password.value = it
                },
                password = password.value,
            )
            Spacer(modifier = modifier.height(24.dp))

            if (!isRegistration.value)
                regComposeItems.LogInButtons(
                    onLogIn = { onLogInAction() },
                    onReg = { isRegistration.value = true },
                )
            else {
                regComposeItems.PasswordConfirm(
                    isSamePassword = password.value != confirmPassword.value && confirmPassword.value.isNotEmpty(),
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
                        else {

                        }
                    }
                )
            }
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