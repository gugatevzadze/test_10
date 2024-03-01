package com.example.test_10.presentation.event

sealed class FromAccountEvent{
    data object FetchAccounts: FromAccountEvent()
    data class Error(val message: String): FromAccountEvent()
}