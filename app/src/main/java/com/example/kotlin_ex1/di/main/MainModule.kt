package com.example.kotlin_ex1.di.main

import android.content.Context
import com.example.kotlin_ex1.data.local.DatabaseLayer
import com.example.kotlin_ex1.repositories.MainRepository
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @MainScope
    @Provides
    fun provideDatabaseLayer(appContext: Context): DatabaseLayer {
        return DatabaseLayer(appContext)
    }

    @MainScope
    @Provides
    fun provideMainRepository(databaseLayer: DatabaseLayer): MainRepository {
        return MainRepository(databaseLayer)
    }

}