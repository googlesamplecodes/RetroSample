package com.google.retrosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.retrosample.dashboard.SelectionFragment
import com.google.retrosample.dashboard.daggers.components.DaggerMainComponents

import com.google.retrosample.dashboard.interfaces.NavigateFragmentListener
import com.google.retrosample.dashboard.viewmodels.SelectionViewModels
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigateFragmentListener {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    //@Inject
    val selectionViewModels: SelectionViewModels by viewModels(){
        viewModelFactory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainComponents.builder().build().inject(this)
       // selectionViewModels = ViewModelProvider(this, viewModelFactory).get(SelectionViewModels::class.java)
        replaceFragment(SelectionFragment())

        // Origin 2

    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framecontainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun replaceFragments(fragment: Fragment) {
        replaceFragment(fragment)
    }
}