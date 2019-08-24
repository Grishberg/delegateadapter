package com.grishberg.horizontalfeed

import com.grishberg.verticalfeeds.FeedItem
import com.grishberg.verticalfeeds.NewsRenderer

interface FeedConverter {
    fun convert(feeds: List<FeedItem<NewsRenderer>>): List<HorizontalItem<*>>
}