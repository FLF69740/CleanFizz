package com.example.cleanfizz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.cleanfizz.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.ClassCastException

class MenuFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    private var mCallback: ChangeFragmentCallback? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val validateBtn = view.findViewById<Button>(R.id.validate)

        validateBtn.setOnClickListener {
            viewModel.responseValidateBtn(
                wordOne = null,
                wordTwo = null,
                numberOne = null,
                numberTwo = null
            )
        }

        viewModel.getScreenValidation().observe(viewLifecycleOwner){ _ ->
            mCallback?.toScreenResult()
        }

        viewModel.getScreenError().observe(viewLifecycleOwner){ _ ->
            mCallback?.toScreenError()
        }

        return view
    }

    companion object {
        fun newInstance() = MenuFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try { mCallback = activity as ChangeFragmentCallback
        }
        catch (e: ClassCastException) { throw ClassCastException("$e must implemented MainInterface") }
    }
}