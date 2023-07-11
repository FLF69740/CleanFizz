package com.example.cleanfizz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.cleanfizz.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ErrorFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_error, container, false)

        val title  = view.findViewById<TextView>(R.id.error_text_title)



        return view
    }

    companion object {
        fun newInstance() = ErrorFragment()
    }


}