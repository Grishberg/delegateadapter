package com.grishberg.feedsui.presentation.rv

import android.view.ViewGroup
import com.github.grishberg.delegateadapter.AdapterDelegate
import com.github.grishberg.delegateadapter.RecycableViewHolder
import com.grishberg.verticalfeeds.FeedItem

internal class NewsFeedAdapterDelegate(
        private val newsViewHolderFactory: NewsViewHolderFactory
) : AdapterDelegate<FeedItem<NewsViewHolder>, NewsViewHolder> {

    override fun onBindViewHolder(vh: NewsViewHolder, item: FeedItem<NewsViewHolder>) {
        item.render(vh)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecycableViewHolder =
            newsViewHolderFactory.create(parent)

    override fun isForType(item: FeedItem<NewsViewHolder>): Boolean =
            item.type() == "news"
}