package com.example.myprojectapp.authentication

sealed interface Events {
    object GetVerificationCode: Events
    object SendVerificationCode: Events
}

sealed interface UIState {
    object Error: UIState
    object Complete: UIState
}