package com.example.kotlin_ex1.ui.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_ex1.R
import kotlinx.android.synthetic.main.activity_main_list_item.view.*
import com.example.kotlin_ex1.ui.models.Todo

class MainRecyclerAdapter :
    PagedListAdapter<Todo, MainRecyclerAdapter.MainViewHolder>(diffCallback) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Todo>() {
            override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean =
                oldItem.todoId == newItem.todoId

            override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main_list_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var todo: Todo? = null

        fun bindTo(item: Todo?) {
            itemView.apply {
                main_ListItemTodoTitleTv.text =
                    item?.title
                        ?: context.getString(R.string.activity_main_list_adapter_title_tv_loading_txt)
                main_ListItemTodoDescriptionTv.text =
                    item?.description
                        ?: context.getString(R.string.activity_main_list_adapter_description_tv_loading_txt)
                main_ListItemTodoImportanceTv.text =
                    Todo.importanceToString(item?.importance)
                        ?: context.getString(R.string.activity_main_list_adapter_importance_tv_loading_txt)
            }
        }
    }

}

