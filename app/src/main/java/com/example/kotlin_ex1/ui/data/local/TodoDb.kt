package com.example.kotlin_ex1.ui.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kotlin_ex1.ui.models.Todo

@Database(entities = [Todo::class], version = 2)
@TypeConverters(Converters::class)
abstract class TodoDb : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {
        private const val DB_NAME = "TodoDb"
        fun get(context: Context) =
            Room.databaseBuilder(context, TodoDb::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}