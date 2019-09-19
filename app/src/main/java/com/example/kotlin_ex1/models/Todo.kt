package com.example.kotlin_ex1.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TodoTable")
data class Todo(
    @PrimaryKey(autoGenerate = true) val todoId: Long = 0L,
    val title: String,
    val description: String,
    val importance: TodoImportance
) {
    enum class TodoImportance {
        LOW, MEDIUM, HIGH
    }

    companion object {
        private val importanceMap = mapOf(
            TodoImportance.LOW to "low importance",
            TodoImportance.MEDIUM to "medium importance",
            TodoImportance.HIGH to "high importance"
        )

        fun importanceToString(importance: TodoImportance?): String? {
            return importanceMap[importance]
        }
    }

}