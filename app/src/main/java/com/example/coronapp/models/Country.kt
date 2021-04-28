package com.example.coronapp.models


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("data")
    var `data`: List<Data>,
    @SerializedName("status")
    val status: Int,
    @SerializedName("type")
    val type: String
)