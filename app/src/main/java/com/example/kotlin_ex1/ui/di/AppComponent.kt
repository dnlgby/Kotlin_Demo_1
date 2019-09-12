package com.example.kotlin_ex1.ui.di

import android.app.Application
import com.example.kotlin_ex1.ui.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, AppModule::class,
        ActivityBuildersModule::class, ViewModelFactoryModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }


    // this is needed because LuaApp has @Inject
    //fun inject(luaApp: BaseApplication)
}