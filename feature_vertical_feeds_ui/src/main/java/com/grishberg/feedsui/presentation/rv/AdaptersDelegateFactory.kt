package com.grishberg.feedsui.presentation.rv

import com.github.grishberg.delegateadapter.AdapterDelegate
import com.github.grishberg.delegateadapter.RecycableViewHolder
import com.grishberg.feedsui.presentation.cards.renderer.RendererProvider
import com.grishberg.verticalfeeds.FeedItem
import javax.inject.Inject

internal class AdaptersDelegateFactory @Inject constructor(
        private val newsViewHolderFactory: NewsViewHolderFactory,
        private val rendererProvider: RendererProvider
) {
    fun createDelegates(): List<AdapterDelegate<out FeedItem, out RecycableViewHolder>> =
            listOf(NewsFeedAdapterDelegate(newsViewHolderFactory,
                    rendererProvider.provideNewsRenderer()))
}