package com.example.test_10.data.mapper

import com.example.test_10.data.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun <T:Any, DomainType> Flow<Resource<T>>.mapToDomain(mapper: (T) -> DomainType): Flow<Resource<DomainType>> {
    return this.map { resource ->
        when (resource) {
            is Resource.Success -> Resource.Success(mapper(resource.data))
            is Resource.Error -> Resource.Error(resource.errorMessage)
            is Resource.Loading -> Resource.Loading(resource.loading)
        }
    }
}