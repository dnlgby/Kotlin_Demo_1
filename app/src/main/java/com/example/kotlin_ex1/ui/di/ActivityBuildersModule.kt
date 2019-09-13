package com.example.kotlin_ex1.ui.di

import com.example.kotlin_ex1.ui.di.main.MainModule
import com.example.kotlin_ex1.ui.di.main.MainScope
import com.example.kotlin_ex1.ui.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @MainScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeMainActivity(): MainActivity
}