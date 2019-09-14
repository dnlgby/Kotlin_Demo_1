package com.example.kotlin_ex1.ui.di

import android.app.Application
import com.example.kotlin_ex1.ui.BaseApplication
import com.example.kotlin_ex1.ui.di.main.MainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
/* these modules 'explaining' the Component, how to create dependencies
   we have there the 'AppModule', the 'ActivityBuildersModule' etc.*/
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent: AndroidInjector<BaseApplication> {

    /*We declare this builder because we want to push object (Application)
      into the dependency graph at runtime.*/
    @Component.Builder
    interface Builder {

        /*Here be bind the application instance, this is a part
          of the builder now, pushed to the dependency graph*/
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    // Extending from 'AndroidInjector<BaseApplication>' makes this 'inject' function not necessary.

    /*We call inject with the application instance to inject into
      the application object the dependencies inside. (All the @Inject annotated vars)
      In our case we are talking on the 'DispatchingAndroidInjector' object. */
    //fun inject(application: BaseApplication)
}



