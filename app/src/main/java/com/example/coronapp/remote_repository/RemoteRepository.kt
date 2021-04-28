package com.example.coronapp.remote_repository

import com.example.coronapp.api.ApiResult
import com.example.coronapp.api.retrofitClient
import com.example.coronapp.api.safeApiCall
import com.example.coronapp.models.Country

object RemoteRepository {
    suspend fun getCountries(): ApiResult<Country> = safeApiCall { retrofitClient.getCountries() }
}