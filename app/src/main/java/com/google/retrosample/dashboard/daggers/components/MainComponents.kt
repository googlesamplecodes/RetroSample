package com.google.retrosample.dashboard.daggers.components


import com.google.retrosample.MainActivity
import com.google.retrosample.dashboard.SelectionFragment
import com.google.retrosample.dashboard.daggers.MainModule
import com.google.retrosample.dashboard.daggers.modules.ViewModelModule
import com.google.retrosample.dashboard.fragments.ConfirmFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class, ViewModelModule::class])
interface MainComponents {
    fun inject(mainActivity: MainActivity)
    fun inject(fragment: SelectionFragment)
    fun inject(fragment: ConfirmFragment)
}