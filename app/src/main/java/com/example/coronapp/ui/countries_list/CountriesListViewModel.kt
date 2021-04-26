package com.example.coronapp.ui.countries_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coronapp.models.Country

class CountriesListViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val countriesList = MutableLiveData<List<Country>>()

    fun getCountries() {
        countriesList.value = listOf(
            Country("USA", "14548", 20000, 200),
            Country("France", "14548", 20000, 201),
            Country("Japan", "14548", 5, 202),
            Country("China", "14548", 5000, 203),
            Country("South Korea", "14548", 3000, 204),
            Country("Spain", "14548", 5000, 205)
        )
    }
}