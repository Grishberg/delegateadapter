package com.grishberg.verticalfeeds

import com.grishberg.detailedinfo.DetailedInfo
import com.grishberg.verticalfeeds.renderer.ads.AdsRenderer
import com.grishberg.verticalfeeds.renderer.news.NewsRenderer

typealias NewsCard = FeedItem<NewsRenderer>
typealias AdsCard = FeedItem<AdsRenderer>
typealias AnyFeedItem = FeedItem<*>

/**
 * Vertical Feed content entity
 */
interface FeedItem<RENDERER> {
    val type: CardType

    fun render(renderer: RENDERER)
    fun isIdEquals(renderer: FeedItem<*>): Boolean
    fun provideDetailedInfo(): DetailedInfo
}