package com.grishberg.horizontalfeed

import com.grishberg.verticalfeeds.NewsCard

interface FeedConverter {
    fun convert(feeds: List<NewsCard>): List<com.grishberg.horizontalfeed.AnyHorizontalCard>
}