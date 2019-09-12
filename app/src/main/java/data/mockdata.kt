package data

import models.Todo

object MockData {
    val data = listOf(
        Todo(3, "Clean bed", "Clean", Todo.TodoImportance.HIGH),
        Todo(4, "Make rice", "Make the rice", Todo.TodoImportance.MEDIUM),
        Todo(5, "Eat", "Eat food", Todo.TodoImportance.LOW)
    )
}