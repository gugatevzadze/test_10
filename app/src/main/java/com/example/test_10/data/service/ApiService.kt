package com.example.test_10.data.service

import com.example.test_10.data.model.AccountDto
import com.example.test_10.data.model.ConversionRate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
        @GET("v3/5c74ec0e-5cc1-445e-b64b-b76b286b215f")
        suspend fun getAccounts(): Response<List<AccountDto>>

        @GET("v3/4253786f-3500-4148-9ebc-1fe7fb9dc8d5")
        suspend fun verifyAccount(@Query("account_number") accountNumber: String): Response<AccountDto>

        @GET("v3/d9eab148-a083-4625-9f9a-9ada0d409ba3")
        suspend fun getConversionRate(@Query("from_account") fromAccount: String, @Query("to_account") toAccount: String): Response<ConversionRate>
}