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
import android.widget.SearchView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.SearchViewBindingAdapter
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.coronapp.R
import com.example.coronapp.adapters.CountryListAdapter
import com.example.coronapp.databinding.CountriesListFragmentBinding
import com.example.coronapp.models.Country
import com.example.coronapp.ui.detail_country.DetailCountryFragment
import kotlin.math.log

class CountriesListFragment : Fragment() {


    /*companion object {
        fun newInstance() = CountriesListFragment()
    }*/

    private lateinit var viewModel: CountriesListViewModel
    private var countryListAdapter: CountryListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(CountriesListViewModel::class.java)

        val binding: CountriesListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.countries_list_fragment, container, false
        )


        viewModel.countriesResponseSuccess.observe(viewLifecycleOwner, { it ->
            countryListAdapter = CountryListAdapter(it.data) {
                val action =
                    CountriesListFragmentDirections.actionCountriesListFragmentToDetailCountryFragment(
                        it.name
                    )
                findNavController().navigate(action)
            }
            binding.recyclerCountries.adapter = countryListAdapter
        })

        viewModel.countriesResponseError.observe(viewLifecycleOwner, {
            Log.d("ErrorCallAPI", it)
        })

        viewModel.getCountries()

        binding.searchEditText.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(text: String?): Boolean {
                if (text != null) {
                    Log.d("onQueryTextChange", "$text")
                    countryListAdapter?.countries = viewModel.getCountryByName(text)
                    binding.recyclerCountries.adapter = countryListAdapter
                }
                return false
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