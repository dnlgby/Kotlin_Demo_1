package com.example.kotlin_ex1.repositories

import androidx.paging.DataSource
import com.example.kotlin_ex1.data.local.TodoDao
import com.example.kotlin_ex1.models.Todo
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MainRepository
@Inject
constructor(
    private val todoDao: TodoDao
)
{
    fun getAllTodo(): DataSource.Factory<Int, Todo>{
        return todoDao.getAllTodo()
    }


    suspend fun insertTodo(todo: Todo) {
        withContext(IO) {
            todoDao.insertTodo(todo)
        }
    }

}