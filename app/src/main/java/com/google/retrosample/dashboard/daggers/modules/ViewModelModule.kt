package com.google.retrosample.dashboard.daggers.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.retrosample.dashboard.viewmodels.SelectionViewModels
import com.google.retrosample.dashboard.viewmodels.ViewModelFactory
import com.google.retrosample.dashboard.viewmodels.ViewModelKey

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
abstract class ViewModelModule{

    @Binds
    @IntoMap
    @ViewModelKey(SelectionViewModels::class)
    abstract fun provideHomeViewModel(homeViewModel: SelectionViewModels):ViewModel


    @Binds
    @Singleton
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory):ViewModelProvider.Factory



}