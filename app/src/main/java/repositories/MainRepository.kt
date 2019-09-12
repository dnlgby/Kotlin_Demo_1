package repositories

import android.content.Context
import androidx.paging.DataSource
import data.local.DatabaseLayer
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import models.Todo

class MainRepository(context: Context) {

    private val databaseLayer = DatabaseLayer(context)

    fun getAllTodo(): DataSource.Factory<Int, Todo> = databaseLayer.getAllTodo()


    suspend fun insertTodo(todo: Todo) =
        withContext(IO) {
            databaseLayer.insertTodo(todo)
        }
}