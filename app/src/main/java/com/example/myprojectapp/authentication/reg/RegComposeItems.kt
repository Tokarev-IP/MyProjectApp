package com.example.myprojectapp.authentication.reg

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.myprojectapp.R

class RegComposeItems {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Email(
        modifier: Modifier = Modifier,
        isError: Boolean,
        emailText: String,
        onEmail: (String) -> Unit,
        errorText: String,
    ) {
        OutlinedTextField(
            value = emailText,
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            modifier = modifier
                .width(320.dp),
            trailingIcon = {
                if (emailText.isNotEmpty())
                    IconButton(onClick = { onEmail("") }) {
                        Icon(Icons.Filled.Clear, contentDescription = "DeleteText")
                    }
            },
            supportingText = {
                if (isError) Text(text = errorText, color = Color.Red)
            },
            label = { Text(text = "e-mail") },
            onValueChange = {
                onEmail(it.trim())
            })
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Password(
        modifier: Modifier = Modifier,
        onPassword: (String) -> Unit,
        password: String,
    ) {
        val passwordHidden = rememberSaveable { mutableStateOf(true) }

        OutlinedTextField(
            value = password,
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            modifier = modifier
                .width(320.dp),
            supportingText = {
                if (password.length < 8) Text(text = "Minimum 8 characters", color = Color.Red)
            },
            label = { Text(text = "Password") },
            onValueChange = {
                onPassword(it.trim())
            },
            visualTransformation =
            if (passwordHidden.value) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                IconButton(onClick = { passwordHidden.value = !passwordHidden.value }) {
                    val visibilityIcon =
                        if (passwordHidden.value)
                            R.drawable.baseline_visibility_24
                        else R.drawable.baseline_visibility_off_24
                    val description =
                        if (passwordHidden.value) "Show password" else "Hide password"
                    Icon(
                        painter = painterResource(visibilityIcon),
                        contentDescription = description
                    )
                }
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PasswordConfirm(
        modifier: Modifier = Modifier,
        isSamePassword: Boolean,
        onPassword: (String) -> Unit,
        password: String,
    ) {
        val passwordHidden = rememberSaveable { mutableStateOf(true) }

        OutlinedTextField(
            value = password,
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            modifier = modifier
                .width(320.dp),
            supportingText = {
                if (isSamePassword)
                    Text(text = "The password isn't the same", color = Color.Red) },
            label = { Text(text = "Confirm password") },
            onValueChange = {
                onPassword(it.trim())
            },
            visualTransformation =
            if (passwordHidden.value) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                IconButton(onClick = { passwordHidden.value = !passwordHidden.value }) {
                    val visibilityIcon =
                        if (passwordHidden.value)
                            R.drawable.baseline_visibility_24
                        else R.drawable.baseline_visibility_off_24
                    val description =
                        if (passwordHidden.value) "Show password" else "Hide password"
                    Icon(
                        painter = painterResource(visibilityIcon),
                        contentDescription = description
                    )
                }
            }
        )
    }

    @Composable
    fun LogInButtons(
        modifier: Modifier = Modifier,
        onLogIn: () -> Unit,
        onReg: () -> Unit,
    ) {
        Row(modifier = modifier.width(320.dp)) {
            Button(
                onClick = { onLogIn() },
                shape = RoundedCornerShape(16.dp),
                modifier = modifier.weight(1f)
            ) {
                Text(text = "Log in")
            }

            Spacer(modifier = modifier.width(32.dp))

            FilledTonalButton(
                onClick = { onReg() },
                shape = RoundedCornerShape(16.dp),
                modifier = modifier.weight(1f)
            ) {
                Text(text = "Registration")
            }
        }
    }

    @Composable
    fun RegButton(
        modifier: Modifier = Modifier,
        onRegButton: () -> Unit,
    ) {
        Button(
            onClick = { onRegButton() },
            shape = RoundedCornerShape(16.dp),
            modifier = modifier.width(320.dp)
        ) {
            Text(text = "Registration")
        }
    }

}