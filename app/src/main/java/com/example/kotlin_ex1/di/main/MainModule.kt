package com.example.kotlin_ex1.di.main

import android.app.Application
import androidx.room.Room
import com.example.kotlin_ex1.data.local.TodoDao
import com.example.kotlin_ex1.data.local.TodoDatabase
import com.example.kotlin_ex1.data.local.TodoDatabase.Companion.DB_NAME
import com.example.kotlin_ex1.repositories.MainRepository
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @MainScope
    @Provides
    fun provideAppDb(app: Application): TodoDatabase {
        return Room
            .databaseBuilder(app, TodoDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration() // get correct db version if schema changed
            .build()
    }

    @MainScope
    @Provides
    fun provideAuthTokenDao(db: TodoDatabase): TodoDao{
        return db.todoDao()
    }

    @MainScope
    @Provides
    fun provideMainRepository(todoDao: TodoDao): MainRepository {
        return MainRepository(todoDao)
    }

}













