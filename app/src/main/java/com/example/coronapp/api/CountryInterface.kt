package com.example.coronapp.api

import com.example.coronapp.models.Country
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryInterface {

    @GET("regions/")
    suspend fun getCountries(): Response<Country>

}