package com.example.test_10.data.mapper

import com.example.test_10.data.model.AccountDto
import com.example.test_10.domain.model.Account

fun AccountDto.toDomain() = Account(
    id = id,
    accountName = accountName,
    accountNumber  = accountNumber,
    valuteType = valuteType,
    cardType = cardType,
    balance = balance,
    cardLogo = cardLogo
)