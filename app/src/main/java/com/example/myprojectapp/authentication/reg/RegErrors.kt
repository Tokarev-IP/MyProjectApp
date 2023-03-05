package com.example.myprojectapp.authentication.reg

sealed class RegErrors {
    data class RegNewAccountError(val text: String) : RegErrors()
    object NoError : RegErrors()
    object RegIsCompleted : RegErrors()
}
