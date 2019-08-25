package com.grishberg.verticalfeeds

import com.grishberg.delegateadapter.ItemWithId

typealias AnyFeedItem = FeedItem<*>

/**
 * Vertical Feed content entity
 */
interface FeedItem<RENDERER> : ItemWithId {
    val type: CardType

    fun render(renderer: RENDERER)
}