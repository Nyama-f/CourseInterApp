package com.example.courseinterapp.ui.adapters.decorators

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FeedVerticalDividerItemDecoration(
    private val divider: Int,
    private val size: Int
): RecyclerView.ItemDecoration() {

        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)

            with(outRect) {
                top = divider
                bottom = divider
                right = divider
                left = divider
            }
            // Для первого элемента устанавливаем отдельный отступ
            if(parent.getChildAdapterPosition(view) == 0){
                outRect.left = 20
            }

            // Для последнего элемента устанавливаем отдельный отступ
            if(parent.getChildAdapterPosition(view) == size - 1){
                outRect.bottom = 20

            }
        }
}