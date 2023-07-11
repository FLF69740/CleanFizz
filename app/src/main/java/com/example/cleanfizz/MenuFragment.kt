package com.example.cleanfizz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.lang.ClassCastException

class MenuFragment : Fragment() {

    private var mCallback: ChangeFragmentCallback? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val validateBtn = view.findViewById<Button>(R.id.validate)

        validateBtn.setOnClickListener {
            mCallback?.toScreenResult()
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