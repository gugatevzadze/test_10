package com.example.test_10.domain.repository

import com.example.test_10.data.model.AccountDto
import com.example.test_10.data.model.ConversionRateDto
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ApiRepository {
    suspend fun getAccounts(): Response<Flow<List<AccountDto>>>
    suspend fun verifyAccount(accountNumber: String): Response<Flow<AccountDto>>
    suspend fun getConversionRate(fromAccount: String, toAccount: String): Response<Flow<ConversionRateDto>>
}