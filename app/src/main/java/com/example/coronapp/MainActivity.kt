package com.example.coronapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coronapp.api.CountryInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val BASE_URL = "https://api.quarantine.country"
    var retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(CountryInterface::class.java)
    val values = service.getCountryList()
}