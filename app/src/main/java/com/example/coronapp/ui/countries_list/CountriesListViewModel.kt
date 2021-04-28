package com.example.coronapp.ui.countries_list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coronapp.api.ApiResult
import com.example.coronapp.models.Country
import com.example.coronapp.models.Data
import com.example.coronapp.remote_repository.RemoteRepository
import kotlinx.coroutines.launch

class CountriesListViewModel : ViewModel() {

    val countriesResponseSuccess: MutableLiveData<Country> = MutableLiveData<Country>()
    val countriesResponseError: MutableLiveData<String> = MutableLiveData<String>()

    fun getCountries() {
        viewModelScope.launch {
            when (val result = RemoteRepository.getCountries()) {
                is ApiResult.Success -> countriesResponseSuccess.postValue(result.data)
                is ApiResult.Error -> countriesResponseError.postValue(result.exception)
            }
        }
    }

    fun getCountryByName(name_region: String): List<Data>? {
        val newListCountry = countriesResponseSuccess.value?.data?.filter {
            it.name.toLowerCase().startsWith(name_region.toLowerCase())
        }
        Log.d("GetCountryByName", newListCountry.toString())
        return newListCountry
    }
}
