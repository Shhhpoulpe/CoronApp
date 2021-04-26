package com.example.coronapp.models

data class Country(
    val name: String? = null,
    val iso: String? = null,
    val totalCases: Int? = null,
    val activeCases: Int? = null,
    val deaths: Int? = null,
    val recovered: Int? = null,
    val critical: Int? = null,
    val tested: Int? = null,
    val deathRatio: Double? = null,
    val recoveryRatio: Double? = null
) {

}