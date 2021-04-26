package com.example.coronapp.models

data class Country(
    val name: String,
    val iso: String,
    val totalCases: Int,
    val activeCases: Int,
    val deaths: Int,
    val recovered: Int,
    val critical: Int,
    val tested: Int,
    val deathRatio: Double,
    val recoveryRatio: Double
) {


}