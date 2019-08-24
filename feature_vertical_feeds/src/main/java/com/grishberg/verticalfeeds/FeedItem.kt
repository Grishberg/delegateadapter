package com.grishberg.verticalfeeds

import com.grishberg.delegateadapter.ItemWithId


/**
 * Vertical Feed content entity
 */
interface FeedItem<R> : ItemWithId {
    fun type(): String

    fun render(renderer: R)
}