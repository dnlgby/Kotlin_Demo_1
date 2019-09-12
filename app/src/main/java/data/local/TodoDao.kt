package data.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import models.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo")
    fun getAllTodo(): DataSource.Factory<Int, Todo>

    @Insert
    suspend fun insertTodo(todo: Todo)
}