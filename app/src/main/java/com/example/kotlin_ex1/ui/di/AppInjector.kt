package com.android.example.github.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.kotlin_ex1.ui.BaseApplication
import com.example.kotlin_ex1.ui.di.DaggerAppComponent
import dagger.android.AndroidInjection

/*This is a static class which has a single functions 'init',
  That function is creating our AppComponent (using the new builder we created - the
  builder with the added runtime dependency injection on the Application object),
  After creation it injecting values into the application object.
  Right after that, is attaches listener to every single Activity of the application -
  A listener which injects dependencies to Activity in the stage of creation 'onActivityCreated'.*/
object AppInjector {
    fun init(application: BaseApplication) {
        DaggerAppComponent.builder().application(application)
            .build().inject(application)
        application
            .registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                    AndroidInjection.inject(activity)
                }

                override fun onActivityStarted(activity: Activity) {

                }

                override fun onActivityResumed(activity: Activity) {

                }

                override fun onActivityPaused(activity: Activity) {

                }

                override fun onActivityStopped(activity: Activity) {

                }

                override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {

                }

                override fun onActivityDestroyed(activity: Activity) {

                }
            })
    }
}
