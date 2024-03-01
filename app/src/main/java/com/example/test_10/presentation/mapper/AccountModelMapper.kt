package com.example.test_10.presentation.mapper

import com.example.test_10.domain.model.Account
import com.example.test_10.presentation.model.AccountModel

fun Account.toPresentation(): AccountModel {
    return AccountModel(
        id = id,
        accountName = accountName,
        accountNumber = accountNumber,
        valuteType = valuteType,
        cardType = cardType,
        balance = balance,
        cardLogo = cardLogo
    )
}