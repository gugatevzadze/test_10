package com.example.test_10.data.repository

import com.example.test_10.data.common.Resource
import com.example.test_10.data.common.ResponseHandler
import com.example.test_10.data.mapper.mapToDomain
import com.example.test_10.data.mapper.toDomain
import com.example.test_10.data.model.ConversionRate
import com.example.test_10.data.service.ApiService
import com.example.test_10.domain.model.Account
import com.example.test_10.domain.repository.ApiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val responseHandler: ResponseHandler
) : ApiRepository {
    override suspend fun getAccounts(): Flow<Resource<List<Account>>> {
        return responseHandler.safeApiCall {
            apiService.getAccounts()
        }.mapToDomain { response ->
            response.map { it.toDomain() }
        }
    }

    override suspend fun verifyAccount(accountNumber: String): Flow<Resource<Account>> {
        return responseHandler.safeApiCall {
            apiService.verifyAccount(accountNumber)
        }.mapToDomain { it.toDomain() }
    }

    override suspend fun getConversionRate(fromAccount: String, toAccount: String): Flow<Resource<ConversionRate>> {
        return responseHandler.safeApiCall {
            apiService.getConversionRate(fromAccount, toAccount)
        }.mapToDomain { it }
    }
}