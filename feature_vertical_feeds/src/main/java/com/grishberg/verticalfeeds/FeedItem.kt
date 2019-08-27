package com.grishberg.verticalfeeds

import com.grishberg.delegateadapter.ItemWithId
import com.grishberg.verticalfeeds.renderer.ads.AdsRenderer
import com.grishberg.verticalfeeds.renderer.news.NewsRenderer

typealias NewsCard = FeedItem<NewsRenderer>
typealias AdsCard = FeedItem<AdsRenderer>
typealias AnyFeedItem = FeedItem<*>

/**
 * Vertical Feed content entity
 */
interface FeedItem<RENDERER> : ItemWithId {
    val type: CardType

    fun render(renderer: RENDERER)
}