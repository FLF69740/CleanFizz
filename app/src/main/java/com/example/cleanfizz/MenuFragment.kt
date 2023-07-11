package com.example.cleanfizz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.cleanfizz.model.FrontFormulary
import com.example.cleanfizz.viewmodel.MainViewModel
import com.example.core.convertString
import com.example.core.convertStringToInt
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.ClassCastException

class MenuFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    private var mCallback: ChangeFragmentCallback? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val validateBtn = view.findViewById<Button>(R.id.validate)
        val wordOneEdit = view.findViewById<EditText>(R.id.word_one)
        val wordTwoEdit = view.findViewById<EditText>(R.id.word_two)
        val numberOneEdit = view.findViewById<EditText>(R.id.number_one)
        val numberTwoEdit = view.findViewById<EditText>(R.id.number_two)
        val limitEdit = view.findViewById<EditText>(R.id.limit)

        validateBtn.setOnClickListener {
            viewModel.responseValidateBtn(
                FrontFormulary(
                    wordOne = wordOneEdit.convertString(),
                    wordTwo = wordTwoEdit.convertString(),
                    numberOne = numberOneEdit.convertStringToInt(),
                    numberTwo = numberTwoEdit.convertStringToInt(),
                    limit = limitEdit.convertStringToInt()
                )
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