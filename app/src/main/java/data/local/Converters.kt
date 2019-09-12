package data.local

import androidx.room.TypeConverter
import models.Todo

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