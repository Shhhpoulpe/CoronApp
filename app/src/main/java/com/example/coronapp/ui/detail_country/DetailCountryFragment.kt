package com.example.coronapp.ui.detail_country

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.coronapp.R
import com.example.coronapp.databinding.DetailCountryFragmentBinding

class DetailCountryFragment : Fragment() {

    private val args: DetailCountryFragmentArgs by navArgs()
    private lateinit var detailsCountryViewModel: DetailCountryViewModel

    companion object {
        fun newInstance() = DetailCountryFragment()
    }

    private lateinit var viewModel: DetailCountryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        detailsCountryViewModel = ViewModelProvider(this).get(DetailCountryViewModel::class.java)

        val binding: DetailCountryFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.detail_country_fragment, container, false
        )

        binding.textView.text = args.country

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailCountryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}