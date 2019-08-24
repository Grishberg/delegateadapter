package com.grishberg.feedsui.presentation.rv

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.grishberg.delegateadapter.CompositeDelegateAdapter
import com.grishberg.verticalfeeds.FeedItem
import javax.inject.Inject

internal class VerticalFeedsAdapter @Inject constructor(factory: AdaptersDelegateFactory) {
    private val adapter = CompositeDelegateAdapter<FeedItem<*>>(factory.createDelegates())
    fun attachToRecyclerView(rv: RecyclerView) {
        rv.adapter = adapter
    }

    fun populate(feeds: List<FeedItem<*>>) {
        DiffUtil.calculateDiff(DiffUtilCallback(adapter.items, feeds))
                .dispatchUpdatesTo(adapter)
        adapter.populate(feeds)
    }
}