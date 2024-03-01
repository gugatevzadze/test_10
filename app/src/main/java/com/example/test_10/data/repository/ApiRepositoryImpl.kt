package com.example.test_10.data.repository

import com.example.test_10.data.service.ApiService
import com.example.test_10.domain.repository.ApiRepository
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ApiRepository{
    override suspend fun getAccounts() = apiService.getAccounts()
    override suspend fun verifyAccount(accountNumber: String) = apiService.verifyAccount(accountNumber)
    override suspend fun getConversionRate(fromAccount: String, toAccount: String) = apiService.getConversionRate(fromAccount, toAccount)
}