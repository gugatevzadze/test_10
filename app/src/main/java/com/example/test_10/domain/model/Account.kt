package com.example.test_10.domain.model


data class Account(
    val id: Int,
    val accountName: String,
    val accountNumber: String,
    val valuteType: String,
    val cardType: String,
    val balance: Int,
    val cardLogo: String?
)