package com.example.kotlin_ex1.ui

import com.example.kotlin_ex1.ui.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {


    override fun applicationInjector() = DaggerAppComponent.builder().application(this).build()

}