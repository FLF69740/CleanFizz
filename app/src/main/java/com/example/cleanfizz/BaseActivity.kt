package com.example.cleanfizz

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity : AppCompatActivity() {
    abstract fun getAttachedLayout(): Int
    abstract fun getFragmentLayout(): Int
    abstract fun getFragment(): Fragment
    abstract fun getCurrentTag(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(getAttachedLayout())
        configureFragment(savedInstanceState)
    }

    private fun configureFragment(bundle: Bundle?){
        if (bundle == null){
            supportFragmentManager.beginTransaction()
                .add(getFragmentLayout(), getFragment())
                .commit()
        }
    }
}