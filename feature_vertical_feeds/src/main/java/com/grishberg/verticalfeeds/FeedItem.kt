package com.grishberg.verticalfeeds

import com.grishberg.detailedinfo.DetailedInfo

typealias NewsCard = FeedItem
typealias AdsCard = FeedItem
typealias AnyFeedItem = FeedItem

/**
 * Vertical Feed content entity
 */
interface FeedItem {
    val type: CardType

    fun render()
    fun isIdEquals(id: Int): Boolean
    fun isIdEquals(other: FeedItem): Boolean
    fun provideDetailedInfo(): DetailedInfo
}