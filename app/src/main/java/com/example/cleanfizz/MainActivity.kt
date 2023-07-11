package com.example.cleanfizz

import androidx.fragment.app.Fragment

class MainActivity : BaseActivity() {
    override fun getAttachedLayout(): Int = R.layout.activity_main

    override fun getFragmentLayout(): Int = R.id.main_activity_fragment_layout

    override fun getFragment(): Fragment = MenuFragment.newInstance()

    override fun getCurrentTag(): String = "MENU_FRAGMENT"

}