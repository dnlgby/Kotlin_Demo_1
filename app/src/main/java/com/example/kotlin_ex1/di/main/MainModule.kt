package com.example.kotlin_ex1.di.main

import android.app.Application
import androidx.room.Room
import com.example.kotlin_ex1.data.local.TodoDao
import com.example.kotlin_ex1.data.local.TodoDatabase
import com.example.kotlin_ex1.data.local.TodoDatabase.Companion.DB_NAME
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @MainScope
    @Provides
    fun provideAppDb(app: Application): TodoDatabase {
        return Room
            .databaseBuilder(app, TodoDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration() // get correct db version if schema changed.
            // In a state of migration, re-construct DB. Loose data.
            .build()
    }

    @MainScope
    @Provides
    fun provideAuthTokenDao(db: TodoDatabase): TodoDao {
        return db.todoDao()
    }

}













