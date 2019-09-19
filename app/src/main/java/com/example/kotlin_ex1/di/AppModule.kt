package com.example.kotlin_ex1.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    // Don't need this. Application instance is already available through @BindsInstance in AppComponent
//    @Singleton
//    @Provides
//    fun provideApplicationContext(app: Application): Context {
//        return app.applicationContext
//    }

}