package com.example.kotlin_ex1.ui.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule {

    @Singleton
    @Provides
    internal fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }

}