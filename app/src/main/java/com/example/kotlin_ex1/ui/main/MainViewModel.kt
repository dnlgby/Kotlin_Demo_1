package com.example.kotlin_ex1.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Config
import androidx.paging.toLiveData
import com.example.kotlin_ex1.models.Todo
import com.example.kotlin_ex1.repositories.MainRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {

    companion object {
        const val TODO_LIST_PAGE_SIZE = 5
        const val TODO_LIST_MAX_SIZE = 200
        const val TODO_LIST_PLACE_HOLDER = true
    }

    @Inject
    lateinit var repository: MainRepository


    val todoListLiveData by lazy {
        repository.getAllTodo()
            .toLiveData(
                Config(
                    pageSize = TODO_LIST_PAGE_SIZE,
                    enablePlaceholders = TODO_LIST_PLACE_HOLDER,
                    maxSize = TODO_LIST_MAX_SIZE
                )
            )
    }

    fun addTodo(todo: Todo) {
        viewModelScope.launch {
            repository.insertTodo(todo)
        }
    }

}