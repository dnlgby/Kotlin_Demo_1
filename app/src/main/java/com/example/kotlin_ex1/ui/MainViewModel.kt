package com.example.kotlin_ex1.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Config
import androidx.paging.toLiveData
import kotlinx.coroutines.launch
import models.Todo
import repositories.MainRepository

class MainViewModel(app: Application) : AndroidViewModel(app) {


    companion object {
        const val TODO_LIST_PAGE_SIZE = 5
        const val TODO_LIST_MAX_SIZE = 200
        const val TODO_LIST_PLACE_HOLDER = true
    }

    private val repository: MainRepository by lazy {
        MainRepository(app.applicationContext)
    }

    val todoListLiveData = repository.getAllTodo()
        .toLiveData(
            Config(
                pageSize = TODO_LIST_PAGE_SIZE,
                enablePlaceholders = TODO_LIST_PLACE_HOLDER,
                maxSize = TODO_LIST_MAX_SIZE
            )
        )

    fun addTodo(todo: Todo) {
        viewModelScope.launch {
            repository.insertTodo(todo)
        }
    }


}