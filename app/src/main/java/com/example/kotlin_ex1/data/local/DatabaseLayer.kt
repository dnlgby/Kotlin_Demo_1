package com.example.kotlin_ex1.data.local

import android.content.Context
import androidx.paging.DataSource
import com.example.kotlin_ex1.models.Todo


class DatabaseLayer(context: Context) {
    private val database = TodoDatabase.getInstance(context)

    fun getAllTodo(): DataSource.Factory<Int, Todo> {
        return database.todoDao().getAllTodo()
    }

    suspend fun insertTodo(todo: Todo) {
        return database.todoDao().insertTodo(todo)
    }

}