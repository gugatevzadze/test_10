package com.example.test_10.domain.repository

import com.example.test_10.data.common.Resource
import com.example.test_10.data.model.ConversionRate
import com.example.test_10.domain.model.Account
import kotlinx.coroutines.flow.Flow

interface ApiRepository {
    suspend fun getAccounts(): Flow<Resource<List<Account>>>
    suspend fun verifyAccount(accountNumber: String): Flow<Resource<Account>>
    suspend fun getConversionRate(fromAccount: String, toAccount: String): Flow<Resource<ConversionRate>>
}