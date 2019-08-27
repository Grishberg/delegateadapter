package com.grishberg.horizontalfeed.cards

import com.grishberg.horizontalfeed.AnyHorizontalCard
import com.grishberg.horizontalfeed.FeedConverter
import com.grishberg.horizontalfeed.HorizontalItem
import com.grishberg.horizontalfeed.TeaserCard
import com.grishberg.horizontalfeed.renderer.teasers.TeaserRenderer
import com.grishberg.verticalfeeds.NewsCard

class FeedConverterImpl : FeedConverter {
    private val adapter = NewsToTeasersRendererAdapter()

    override fun convert(feeds: List<NewsCard>): List<com.grishberg.horizontalfeed.AnyHorizontalCard> {
        val newItems = mutableListOf<com.grishberg.horizontalfeed.TeaserCard>()
        for (f in feeds) {
            newItems.add(TeaserItem(f, adapter))
        }
        return newItems
    }
}