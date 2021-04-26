package com.example.coronapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.coronapp.api.CountryInterface
import com.example.coronapp.models.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BASE_URL = "https://api.quarantine.country"
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CountryInterface::class.java)
        val countryDatas = service.getCountryList()

        countryDatas.enqueue(object: Callback<List<Country>> {
        override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
            val allcountryData = response.body()
            allcountryData?.let {
                for( countryData in it) {
                    Log.d("Country","Country: ${countryData.name}")
                }
            }
        }
        override fun onFailure(call: Call<List<Country>>, t: Throwable) {
            Log.e("Country", "Error : $t")
        }
    })
    }


}