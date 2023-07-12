package com.example.cleanfizz.presentation.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanfizz.R

class FizzBuzzHolder(
    inflater: LayoutInflater,
    parent: ViewGroup
) : RecyclerView.ViewHolder(inflater.inflate(
    R.layout.fizz_buzz_single_item,
    parent,
    false
)) {

    fun setItem(fizzBuzzValue: String, clickListener: (String) -> Unit) {

        val name = itemView.findViewById<TextView>(R.id.fizz_buzz_item_name)
        name.text = fizzBuzzValue

        this.itemView.setOnClickListener {
            clickListener(fizzBuzzValue)
        }
    }
}