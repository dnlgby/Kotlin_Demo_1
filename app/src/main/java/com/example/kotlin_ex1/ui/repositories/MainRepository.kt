package com.example.kotlin_ex1.ui.repositories

import androidx.paging.DataSource
import com.example.kotlin_ex1.ui.data.local.DatabaseLayer
import com.example.kotlin_ex1.ui.models.Todo
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class MainRepository(private val databaseLayer: DatabaseLayer) {


    fun getAllTodo(): DataSource.Factory<Int, Todo> = databaseLayer.getAllTodo()

    suspend fun insertTodo(todo: Todo) =
        withContext(IO) {
            databaseLayer.insertTodo(todo)
        }
}