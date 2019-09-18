package com.example.kotlin_ex1.data.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin_ex1.models.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM TodoTable")
    fun getAllTodo(): DataSource.Factory<Int, Todo>

    @Insert
    suspend fun insertTodo(todo: Todo)
}