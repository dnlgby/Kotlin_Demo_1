package com.example.kotlin_ex1.ui.di.main

import android.content.Context
import com.example.kotlin_ex1.ui.repositories.MainRepository
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @MainScope
    @Provides
    fun provideMainRepository(appContext: Context): MainRepository {
        return MainRepository(appContext)
    }

}