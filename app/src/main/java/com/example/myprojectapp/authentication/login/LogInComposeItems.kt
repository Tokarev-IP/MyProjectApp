package com.example.myprojectapp.authentication.login

import androidx.compose.foundation.layout.*
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

class LogInComposeItems {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EmailOrMobile(
        modifier: Modifier = Modifier,
        isError: Boolean,
        text: String,
        onText: (String) -> Unit,
        errorText: String,
    ) {
        OutlinedTextField(
            value = text,
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            modifier = modifier
                .width(320.dp),
            trailingIcon = {
                if (text.isNotEmpty())
                    IconButton(onClick = { onText("") }) {
                        Icon(Icons.Filled.Clear, contentDescription = "DeleteText")
                    }
            },
            supportingText = {
                if (isError) Text(text = errorText, color = Color.Red)
            },
            label = { Text(text = "e-mail or mobile") },
            onValueChange = {
                onText(it.trim())
            })
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Password(
        modifier: Modifier = Modifier,
        onPassword: (String) -> Unit,
        password: String,
        isError: Boolean,
        errorText: String,
    ) {
        val passwordHidden = rememberSaveable { mutableStateOf(true) }

        OutlinedTextField(
            value = password,
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            modifier = modifier
                .width(320.dp),
            supportingText = {
                if (isError) Text(text = errorText, color = Color.Red)
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

    @Composable
    fun LogInButton(
        modifier: Modifier = Modifier,
        onLogInButton: () -> Unit,
        isEnabled: Boolean,
    ) {
        Button(
            onClick = { onLogInButton() },
            shape = RoundedCornerShape(16.dp),
            modifier = modifier.width(320.dp),
            enabled = isEnabled,
        ) {
            Text(text = "Log In")
        }
    }
}