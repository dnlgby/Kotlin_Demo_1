package com.example.kotlin_ex1.ui.main

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.kotlin_ex1.models.Todo


@BindingAdapter("ImportanceAdapter")
fun TextView.setImportanceValue(importance: Todo.TodoImportance?){
    importance?.let {
        text = Todo.importanceToString(importance)
    }
}