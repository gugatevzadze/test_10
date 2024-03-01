package com.example.test_10.presentation.screen.bottom_sheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_10.data.common.Resource
import com.example.test_10.domain.repository.ApiRepository
import com.example.test_10.domain.usecase.AccountValidationUseCase
import com.example.test_10.presentation.event.FromAccountEvent
import com.example.test_10.presentation.mapper.toPresentation
import com.example.test_10.presentation.state.FromBottomSheetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FromAccountViewModel @Inject constructor(
    private val repository: ApiRepository
): ViewModel() {
    private val _accountsState = MutableStateFlow(FromBottomSheetState())
    val accountsState: SharedFlow<FromBottomSheetState> get()= _accountsState

    fun onEvent(event: FromAccountEvent) {
        when(event) {
            is FromAccountEvent.FetchAccounts -> fetchAccounts()
            is FromAccountEvent.Error -> updateErrorMessages(event.message)
        }
    }

    private fun fetchAccounts() {
        viewModelScope.launch {
            handleResource(
                resourceFlow = repository.getAccounts(),
                handleSuccess = { resourceAccounts ->
                    _accountsState.update { currentState ->
                        currentState.copy(accounts = resourceAccounts.map { it.toPresentation() })
                    }
                }
            )
        }
    }

    private fun updateErrorMessages(message: String?) {
        _accountsState.update { currentState ->
            currentState.copy(
                errorMessage = message
            )
        }
    }

    private fun <T> handleResource(resourceFlow: Flow<Resource<T>>, handleSuccess: (T) -> Unit) {
        viewModelScope.launch {
            resourceFlow.collect { resource ->
                when (resource) {
                    is Resource.Success -> handleSuccess(resource.data)
                    is Resource.Error -> updateErrorMessages(resource.errorMessage)
                    is Resource.Loading -> _accountsState.update { currentState ->
                        currentState.copy(isLoading = resource.loading)
                    }
                }
            }
        }
    }
}