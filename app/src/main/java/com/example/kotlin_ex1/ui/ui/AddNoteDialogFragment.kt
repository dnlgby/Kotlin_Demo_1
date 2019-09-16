package com.example.kotlin_ex1.ui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.DialogFragment
import com.example.kotlin_ex1.R
import kotlinx.android.synthetic.main.add_note_dialog_fragment.view.*
import com.example.kotlin_ex1.ui.models.Todo

class AddNoteDialogFragment(private val clicksListener: AddNoteDialogFragmentActions) :
    DialogFragment() {

    private lateinit var dialogView: View

    companion object {
        fun getInstance(clicksListener: AddNoteDialogFragmentActions): AddNoteDialogFragment {
            return AddNoteDialogFragment(clicksListener)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_note_dialog_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialogView = view
        dialogView.main_AddNoteDialogFragmentTodoOkBtn.apply {
            setOnClickListener {
                clicksListener.userClickedOk(getTodoItem())
                this@AddNoteDialogFragment.dismiss()
            }
        }

        dialogView.main_AddNoteDialogFragmentTodoCancelBtn.apply {
            setOnClickListener {
                this@AddNoteDialogFragment.dismiss()
            }
        }

    }

    private fun getTodoItem(): Todo {
        // No input verifying
        val rb = dialogView.findViewById<RadioButton>(
            dialogView.main_AddNoteDialogFragmentTodoImportanceRg.checkedRadioButtonId
        )

        val title = dialogView.main_AddNoteDialogFragmentTodoTitleEt.text.toString()
        val description = dialogView.main_AddNoteDialogFragmentTodoDescriptionEt.text.toString()

        val importance = when (rb) {
            dialogView.main_AddNoteDialogFragmentTodoImportanceLowRb -> Todo.TodoImportance.LOW
            dialogView.main_AddNoteDialogFragmentTodoImportanceMediumRb -> Todo.TodoImportance.MEDIUM
            dialogView.main_AddNoteDialogFragmentTodoImportanceHighRb -> Todo.TodoImportance.HIGH
            else -> null
        }

        return Todo(title = title, description = description, importance = importance!!)
    }

    interface AddNoteDialogFragmentActions {
        fun userClickedOk(todo: Todo)
    }
}