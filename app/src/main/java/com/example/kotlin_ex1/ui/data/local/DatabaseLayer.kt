package com.example.kotlin_ex1.ui.data.local

import android.content.Context
import androidx.paging.DataSource
import com.example.kotlin_ex1.ui.models.Todo
import javax.inject.Inject

class DatabaseLayer(context: Context) {
    private val database = TodoDb.get(context)

    fun getAllTodo(): DataSource.Factory<Int, Todo> {
        return database.todoDao().getAllTodo()
    }

    suspend fun insertTodo(todo: Todo) {
        return database.todoDao().insertTodo(todo)
    }
}