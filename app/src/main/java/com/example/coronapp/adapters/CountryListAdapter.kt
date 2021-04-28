package com.example.coronapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coronapp.databinding.ItemCountryBinding
import com.example.coronapp.models.Country
import com.example.coronapp.models.Data

class CountryListAdapter(
    var countries: List<Data>?,
    val onCountrySelected: (country: Data) -> Unit?
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
        holder.bind(countries?.get(position)!!)
    }

    inner class CountryViewHolder(private val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(country: Data) {
            binding.country = country
            binding.root.setOnClickListener { onCountrySelected(country) }
        }

    }

    override fun getItemCount(): Int = countries?.size!!

}