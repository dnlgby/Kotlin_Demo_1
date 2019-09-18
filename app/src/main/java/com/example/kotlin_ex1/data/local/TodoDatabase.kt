package com.example.kotlin_ex1.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kotlin_ex1.models.Todo


@Database(entities = [Todo::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {
        private const val DB_NAME = "TodoDatabase"

        @Volatile
        private lateinit var INSTANCE: TodoDatabase

        fun getInstance(context: Context): TodoDatabase {
            synchronized(this) {
                if (!::INSTANCE.isInitialized)
                    INSTANCE = Room.databaseBuilder(context, TodoDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration() // In a state of migration, re-construct DB. Loose data.
                        .build()

                return INSTANCE
            }
        }
    }
}