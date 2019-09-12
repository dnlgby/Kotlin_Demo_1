package com.example.kotlin_ex1.ui.di.main

import androidx.lifecycle.ViewModel
import com.example.kotlin_ex1.ui.di.ViewModelKey
import com.example.kotlin_ex1.ui.ui.MainViewModel
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