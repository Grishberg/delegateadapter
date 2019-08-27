package com.grishberg.horizontalfeed.cards

import com.grishberg.horizontalfeed.AnyHorizontalCard
import com.grishberg.horizontalfeed.FeedConverter
import com.grishberg.horizontalfeed.HorizontalItem
import com.grishberg.horizontalfeed.TeaserCard
import com.grishberg.horizontalfeed.renderer.teasers.TeaserRenderer
import com.grishberg.verticalfeeds.FeedItem
import com.grishberg.verticalfeeds.NewsCard
import com.grishberg.verticalfeeds.renderer.news.NewsRenderer

class FeedConverterImpl : FeedConverter {
    private val adapter = NewsToTeasersRendererAdapter()

    override fun convert(feeds: List<NewsCard>): List<AnyHorizontalCard> {
        val newItems = mutableListOf<TeaserCard>()
        for (f in feeds) {
            newItems.add(TeaserItem(f, adapter))
        }
        return newItems
    }
}