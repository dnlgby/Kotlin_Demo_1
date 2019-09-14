package com.example.kotlin_ex1.ui.di

import android.app.Application
import android.content.Context
import com.example.kotlin_ex1.ui.di.main.MainScope
import com.example.kotlin_ex1.ui.repositories.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(app: Application): Context {
        return app.applicationContext
    }

}