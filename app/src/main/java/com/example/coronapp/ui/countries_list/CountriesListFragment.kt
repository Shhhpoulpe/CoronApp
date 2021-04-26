package com.example.coronapp.ui.countries_list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.Layout
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.coronapp.R
import com.example.coronapp.adapters.CountryListAdapter
import com.example.coronapp.databinding.CountriesListFragmentBinding
import com.example.coronapp.ui.detail_country.DetailCountryFragment

class CountriesListFragment : Fragment() {


    /*companion object {
        fun newInstance() = CountriesListFragment()
    }*/

    private lateinit var viewModel: CountriesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(CountriesListViewModel::class.java)

        val binding: CountriesListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.countries_list_fragment, container, false
        )


        viewModel.countriesList.observe(viewLifecycleOwner, { countries ->
            val countryListAdapter = CountryListAdapter(countries) { country ->

                Toast.makeText(
                    context,
                    "Country name : " + country.name + ", Total cases : " + country.totalCases.toString() + ", Active cases : " + country.activeCases.toString(),
                    Toast.LENGTH_LONG
                ).show()

                val action =
                    CountriesListFragmentDirections.actionCountriesListFragmentToDetailCountryFragment()
                view?.findNavController()?.navigate(action)
            }
            binding.recyclerCountries.adapter = countryListAdapter
        })

        viewModel.getCountries()

        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("beforeTextChanged", "$p0")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("OnTextChanged", "$p0")
                // Call API
            }

            override fun afterTextChanged(p0: Editable?) {
                Log.d("afterTextChanged", "$p0")
            }

        })
        return binding.root
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CountriesListViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

}