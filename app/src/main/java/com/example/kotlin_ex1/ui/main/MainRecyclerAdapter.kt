package com.example.kotlin_ex1.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_ex1.databinding.ActivityMainListItemBinding
import com.example.kotlin_ex1.models.Todo


class MainRecyclerAdapter :
    PagedListAdapter<Todo, MainRecyclerAdapter.MainViewHolder>(
        AsyncDifferConfig.Builder<Todo>(DIFF_CALLBACK).build()
    ) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Todo>() {
            override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean =
                oldItem.todoId == newItem.todoId

            override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    class MainViewHolder private constructor(private val binding: ActivityMainListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): MainViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ActivityMainListItemBinding.inflate(inflater, parent, false)
                return MainViewHolder(binding)
            }
        }

        fun bindTo(item: Todo?) {
            binding.todoItem = item
        }
    }

}

