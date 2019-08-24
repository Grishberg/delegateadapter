package com.grishberg.feedsui.presentation.rv

import androidx.recyclerview.widget.DiffUtil
import com.grishberg.verticalfeeds.FeedItem

class DiffUtilCallback(
        private val oldItems: List<FeedItem<*>>,
        private val newItems: List<FeedItem<*>>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldItems[oldItemPosition].type() == newItems[newItemPosition].type()

    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldItems[oldItemPosition].id == newItems[newItemPosition].id
}