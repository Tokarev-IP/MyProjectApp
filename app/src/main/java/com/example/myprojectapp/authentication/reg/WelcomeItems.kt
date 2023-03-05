package com.example.myprojectapp.authentication.reg

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class WelcomeItems {

    @Composable
    fun MainCompose(
        modifier: Modifier = Modifier,
        onReg: () -> Unit,
        onLogIn: () -> Unit,
        onGoogle: () -> Unit,
    ) {
        Column(
            modifier = modifier
                .padding(top = 80.dp)
        ) {

            ActionButtonOne(text = "Log In", width = 160.dp, onClick = { onLogIn() })
            Spacer(modifier = modifier.height(24.dp))

            ActionButtonTwo(text = "Registration", width = 160.dp, onClick = { onReg() })
            Spacer(modifier = modifier.height(24.dp))

            ActionButtonTwo(text = "Google", width = 160.dp, onClick = { onGoogle() })
        }
    }

    @Composable
    fun ActionButtonOne(
        modifier: Modifier = Modifier,
        text: String,
        width: Dp,
        onClick: () -> Unit,
    ) {
        Button(
            onClick = { onClick() },
            modifier = modifier
                .width(width)
        ) {
            Text(text = text)
        }
    }

    @Composable
    fun ActionButtonTwo(
        modifier: Modifier = Modifier,
        text: String,
        width: Dp,
        onClick: () -> Unit,
    ) {
        FilledTonalButton(
            onClick = { onClick() },
            modifier = modifier
                .width(width)
        ) {
            Text(text = text)
        }
    }
}