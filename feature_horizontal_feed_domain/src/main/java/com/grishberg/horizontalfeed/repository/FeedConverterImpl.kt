package com.grishberg.horizontalfeed.repository

import com.grishberg.horizontalfeed.FeedConverter
import com.grishberg.horizontalfeed.HorizontalItem
import com.grishberg.horizontalfeed.teasers.TeaserRenderer
import com.grishberg.verticalfeeds.FeedItem
import com.grishberg.verticalfeeds.NewsRenderer

class FeedConverterImpl : FeedConverter {
    private val adapter = NewsToTeasersRendererAdapter()

    override fun convert(feeds: List<FeedItem<NewsRenderer>>): List<HorizontalItem<*>> {
        val newItems = mutableListOf<HorizontalItem<TeaserRenderer>>()
        for (f in feeds) {
            newItems.add(TeaserItem(f, adapter))
        }
        return newItems
    }
}