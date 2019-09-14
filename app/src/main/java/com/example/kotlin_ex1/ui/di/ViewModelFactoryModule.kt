package com.example.kotlin_ex1.ui.di

import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_ex1.ui.viewmodel.AppViewModelFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {

    @Binds
    /*When i'm asking for a ViewModelProvider.Factory you will provide me the AppViewModelFactory*/
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}