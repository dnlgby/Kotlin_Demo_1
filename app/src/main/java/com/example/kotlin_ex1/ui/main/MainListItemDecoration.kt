package com.example.kotlin_ex1.ui.main

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class MainListItemDecoration(private val space: Int)
    : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = space
        if (parent.getChildAdapterPosition(view) == 0)
            outRect.top = space

        outRect.right = space
        outRect.left = space

        MainActivity.LIST_SPACING
    }
}