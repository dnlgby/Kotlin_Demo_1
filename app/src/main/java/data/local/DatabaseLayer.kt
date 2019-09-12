package data.local

import android.content.Context
import androidx.paging.DataSource
import models.Todo

class DatabaseLayer(context: Context) {
    private val database = TodoDb.get(context)

    fun getAllTodo(): DataSource.Factory<Int, Todo> {
        return database.todoDao().getAllTodo()
    }

    suspend fun insertTodo(todo: Todo) {
        return database.todoDao().insertTodo(todo)
    }
}