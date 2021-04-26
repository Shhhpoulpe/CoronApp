package com.example.coronapp.ui.countries_list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.coronapp.R
import com.example.coronapp.adapters.CountryListAdapter
import com.example.coronapp.databinding.CountriesListFragmentBinding

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
            val countryListAdapter = CountryListAdapter(countries)
            binding.recyclerCountries.adapter = countryListAdapter
        })

        viewModel.getCountries()

        return binding.root
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CountriesListViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

}