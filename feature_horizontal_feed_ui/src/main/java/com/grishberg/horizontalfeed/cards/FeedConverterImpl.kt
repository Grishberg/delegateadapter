package com.grishberg.horizontalfeed.cards

import com.grishberg.horizontalfeed.AnyHorizontalCard
import com.grishberg.horizontalfeed.FeedConverter
import com.grishberg.horizontalfeed.TeaserCard
import com.grishberg.verticalfeeds.NewsCard

class FeedConverterImpl : FeedConverter {
    // TODO: provide renderer for item.

    override fun convert(feeds: List<NewsCard>): List<AnyHorizontalCard> {
        val newItems = mutableListOf<TeaserCard>()
        for (f in feeds) {
            newItems.add(TeaserItem(f))
        }
        return newItems
    }
}