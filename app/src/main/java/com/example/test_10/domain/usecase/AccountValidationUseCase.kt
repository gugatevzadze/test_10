package com.example.test_10.domain.usecase

class AccountValidationUseCase {

    fun isValidAccountNumber(accountNumber: String): Boolean {
        return accountNumber.length == 23
    }

    fun isValidPersonalNumber(personalNumber: String): Boolean {
        return personalNumber.length == 11 && personalNumber.all { it.isDigit() }
    }

    fun isValidPhoneNumber(phoneNumber: String): Boolean {
        return phoneNumber.length == 9 && phoneNumber.all { it.isDigit() }
    }
}