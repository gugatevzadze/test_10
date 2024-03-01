package com.example.test_10.presentation.model

data class AccountModel(
    val id: Int,
    val accountName: String,
    val accountNumber: String,
    val valuteType: String,
    val cardType: String,
    val balance: Int,
    val cardLogo: String?
)