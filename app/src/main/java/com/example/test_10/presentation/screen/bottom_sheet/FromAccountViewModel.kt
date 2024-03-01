package com.example.test_10.presentation.screen.bottom_sheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_10.data.model.AccountDto
import com.example.test_10.domain.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FromAccountViewModel @Inject constructor(
    private val repository: ApiRepository
): ViewModel() {
    private val _accounts = MutableStateFlow<List<AccountDto>>(emptyList())
    val accounts: StateFlow<List<AccountDto>> = _accounts

    init {
        fetchAccounts()
    }

    private fun fetchAccounts() {
        viewModelScope.launch {
            val response = repository.getAccounts()
            if (response.isSuccessful) {
                response.body()?.let { flow ->
                    flow.collect { accounts ->
                        _accounts.value = accounts
                    }
                }
            } else {
            }
        }
    }
}