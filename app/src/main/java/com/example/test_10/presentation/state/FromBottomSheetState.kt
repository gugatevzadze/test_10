package com.example.test_10.presentation.state

import com.example.test_10.presentation.model.AccountModel

data class FromBottomSheetState(
    val accounts: List<AccountModel>? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false
)