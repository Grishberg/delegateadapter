package com.grishberg.feedsui.presentation.rv

import android.view.ViewGroup
import com.github.grishberg.delegateadapter.AdapterDelegate
import com.github.grishberg.delegateadapter.RecycableViewHolder
import com.grishberg.feedsui.presentation.cards.renderer.news.NewsRenderer
import com.grishberg.feedsui.presentation.cards.renderer.news.NewsRendererProxy
import com.grishberg.verticalfeeds.CardType
import com.grishberg.verticalfeeds.FeedItem

internal class NewsFeedAdapterDelegate(
        private val newsViewHolderFactory: NewsViewHolderFactory,
        private val renderer: NewsRendererProxy
) : AdapterDelegate<FeedItem, NewsViewHolder> {

    override fun onBindViewHolder(vh: NewsViewHolder, item: FeedItem) {
        renderer.attachViewHolder(vh)
        item.render()
    }

    override fun onRecycled() {
        renderer.detachViewHolder()
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecycableViewHolder =
            newsViewHolderFactory.create(parent)

    override fun isForType(item: FeedItem): Boolean =
            item.type == CardType.NEWS
}