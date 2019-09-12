package com.example.kotlin_ex1.ui.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_ex1.R
import com.example.kotlin_ex1.ui.di.ViewModelProviderFactory
import com.example.kotlin_ex1.ui.models.Todo
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(),
    AddNoteDialogFragment.AddNoteDialogFragmentActions {

    companion object {
        const val LIST_SPACING = 10
        const val ADD_NOTE_DIALOG_TAG = "com.example.kotlin_ex1.ui.ui.AddNoteDialogFragment"
    }

    @Inject
    internal lateinit var mViewModelProviderFactory: ViewModelProviderFactory
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainListAdapter: MainRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadUi()
        loadViewModel()
    }

    private fun loadUi() {
        mainListAdapter = MainRecyclerAdapter()
        main_todoRecycler.apply {
            addItemDecoration(
                MainListItemDecoration(LIST_SPACING)
            )
            layoutManager = LinearLayoutManager(context)
            adapter = mainListAdapter
        }

        main_activityMainAddNoteFab.apply {
            setOnClickListener {
                val dialog =
                    AddNoteDialogFragment.getInstance(this@MainActivity)
                dialog.show(
                    supportFragmentManager,
                    ADD_NOTE_DIALOG_TAG
                )
            }
        }
    }

    private fun loadViewModel() {
        mainViewModel =
            ViewModelProvider(this, mViewModelProviderFactory).get(MainViewModel::class.java)
        observeViewModel()
    }

    private fun observeViewModel() {
        mainViewModel.todoListLiveData.observe(this, Observer {
            mainListAdapter.submitList(it)
        })
    }

    override fun userClickedOk(todo: Todo) {
        mainViewModel.addTodo(todo)
    }


}