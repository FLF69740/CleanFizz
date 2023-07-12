package com.example.cleanfizz.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanfizz.model.FrontItemFizzBuzz
import com.example.cleanfizz.presentation.adapter.holder.FizzBuzzHolder

class FizzBuzzListAdapter(private val fizzBuzz: FrontItemFizzBuzz, private val clickListener: (String) -> Unit) : RecyclerView.Adapter<FizzBuzzHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FizzBuzzHolder =
        FizzBuzzHolder(LayoutInflater.from(parent.context), parent)


    override fun getItemCount(): Int = fizzBuzz.mList.size

    override fun onBindViewHolder(holder: FizzBuzzHolder, position: Int) {
        holder.setItem(fizzBuzzValue = fizzBuzz.mList[position], clickListener)
    }
}