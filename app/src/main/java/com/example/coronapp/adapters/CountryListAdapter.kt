package com.example.coronapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coronapp.databinding.ItemCountryBinding
import com.example.coronapp.models.Country

class CountryListAdapter(
    private val countries: List<Country>,
    val onCountrySelected: (country: Country) -> Unit
) :
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    inner class CountryViewHolder(private val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(country: Country) {
            binding.country = country
            binding.root.setOnClickListener { onCountrySelected(country) }
        }

    }

    override fun getItemCount() = countries.size

}