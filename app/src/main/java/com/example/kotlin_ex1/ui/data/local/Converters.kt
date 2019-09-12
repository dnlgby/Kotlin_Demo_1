package com.example.kotlin_ex1.ui.data.local

import androidx.room.TypeConverter
import com.example.kotlin_ex1.ui.models.Todo

object Converters {

    @TypeConverter
    @JvmStatic
    fun fromImportanceToInt(importance: Todo.TodoImportance): Int {
        return importance.ordinal
    }

    @TypeConverter
    @JvmStatic
    fun fromIntToImportance(ordinal: Int): Todo.TodoImportance {
        return Todo.TodoImportance.values()[ordinal]
    }
}