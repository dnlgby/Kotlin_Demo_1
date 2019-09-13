package com.example.kotlin_ex1.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_ex1.ui.ui.MainViewModel
import com.example.kotlin_ex1.ui.viewmodel.AppViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    /*When i'm asking for a ViewModelProvider.Factory you will provide me the AppViewModelFactory*/
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}