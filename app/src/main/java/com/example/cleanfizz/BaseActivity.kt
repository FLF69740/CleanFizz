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

    protected fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(getFragmentLayout(), fragment)
            .commit()
    }
}