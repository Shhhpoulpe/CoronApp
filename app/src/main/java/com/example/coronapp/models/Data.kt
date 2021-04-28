package com.example.coronapp.models


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val name: String
)