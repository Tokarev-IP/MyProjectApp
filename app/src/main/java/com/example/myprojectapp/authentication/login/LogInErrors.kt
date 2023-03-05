package com.example.myprojectapp.authentication.login

sealed class LogInErrors {
    data class LogInError(val text: String) : LogInErrors()
    object NoError : LogInErrors()
    object LogInIsCompleted : LogInErrors()
}
