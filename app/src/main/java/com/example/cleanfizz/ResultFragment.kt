package com.example.cleanfizz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanfizz.presentation.adapter.FizzBuzzListAdapter
import com.example.cleanfizz.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    private var mCallback: ChangeFragmentCallback? = null

    private lateinit var mAdapter: FizzBuzzListAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        recyclerView = view.findViewById(R.id.recyclerview_fizz_buzz)

        context?.let { letContext ->
            viewModel.getFizzBuzzList().observe(viewLifecycleOwner){
                mAdapter = FizzBuzzListAdapter(
                    fizzBuzz = it
                ) {key ->
                    Toast.makeText(letContext, key, Toast.LENGTH_SHORT).show()
                }

                recyclerView.apply {
                    this.adapter = mAdapter
                    this.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
                    this.layoutAnimation = AnimationUtils.loadLayoutAnimation(recyclerView.context, R.anim.layout_slide_from_right)
                }

                recyclerView.scheduleLayoutAnimation()
            }

            viewModel.responseFizzBuzzList(letContext)
        }

        viewModel.getScreenError().observe(viewLifecycleOwner){ _ ->
            mCallback?.toScreenError()
        }

        return view
    }

    companion object {
        fun newInstance() = ResultFragment()
    }
}