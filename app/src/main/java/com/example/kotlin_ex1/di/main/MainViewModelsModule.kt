package com.example.kotlin_ex1.di.main

import androidx.lifecycle.ViewModel
import com.example.kotlin_ex1.di.ViewModelKey
import com.example.kotlin_ex1.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}