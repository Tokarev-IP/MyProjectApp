package com.example.myprojectapp.registration

sealed class RegErrors{
    data class RegNewAccountError(val text: String) : RegErrors()
    data class LogInAccountError(val text: String): RegErrors()
    object NoError: RegErrors()
}
