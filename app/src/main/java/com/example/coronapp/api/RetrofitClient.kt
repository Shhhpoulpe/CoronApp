package com.example.coronapp.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.quarantine.country/api/v1/"

val retrofitClient: CountryInterface by lazy {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return@lazy retrofit.create(CountryInterface::class.java)
}