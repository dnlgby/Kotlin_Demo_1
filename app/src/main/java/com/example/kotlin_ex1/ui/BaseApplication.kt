package com.example.kotlin_ex1.ui

import android.app.Activity
import android.app.Application
import com.android.example.github.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BaseApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        /*
           Here, at the moment of the Application creation, we initialize the application
           Component and injecting application fields & attaching the listeners for Activity creation
           injections as well.
         */
        AppInjector.init(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector
}