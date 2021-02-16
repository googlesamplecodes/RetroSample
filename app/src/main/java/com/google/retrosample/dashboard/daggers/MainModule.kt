package com.google.retrosample.dashboard.daggers

import com.google.retrosample.dashboard.repositories.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainModule  {

    @Singleton
    @Provides
    fun providesMainRepository(): MainRepository {
        return MainRepository()
    }
}