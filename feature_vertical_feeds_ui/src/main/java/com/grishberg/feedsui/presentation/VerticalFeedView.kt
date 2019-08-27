package com.grishberg.feedsui.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.grishberg.feedsui.presentation.rv.AdaptersDelegateFactory
import com.grishberg.feedsui.presentation.rv.NewsViewHolderFactory
import com.grishberg.feedsui.presentation.rv.VerticalFeedsAdapter
import com.grishberg.verticalfeeds.AnyFeedItem

internal class VerticalFeedView constructor(
        viewModel: VerticalFeedViewModel,
        ctx: FragmentActivity
) : RecyclerView(ctx) {

    private val newsViewHolderFactory = NewsViewHolderFactory(LayoutInflater.from(ctx))
    private val adaptersDelegateFactory = AdaptersDelegateFactory(newsViewHolderFactory)
    private val adapter = VerticalFeedsAdapter(adaptersDelegateFactory)

    init {
        adapter.attachToRecyclerView(this)
        val lm = LinearLayoutManager(ctx, VERTICAL, false)
        layoutManager = lm
        viewModel.feeds.observe(ctx, Observer<List<AnyFeedItem>> { feeds ->
            adapter.populate(feeds)
        })
    }
}