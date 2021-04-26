package com.example.coronapp.api

import com.example.coronapp.models.Country
import retrofit2.Call
import retrofit2.http.GET

interface CountryInterface {
    @GET("api/v1/summary/latest")
    fun getCountryList(): Call<List<Country>>
}