package com.grishberg.content

import com.grishberg.horizontalfeed.AnyHorizontalCard
import com.grishberg.verticalfeeds.AnyFeedItem

interface ContentDetails {
    fun registerOutputBounds(bounds: OutputBounds)
    fun unregisterOutputBounds(bounds: OutputBounds)

    fun requestCardDetails(card: AnyHorizontalCard)
    fun requestCardDetails(card: AnyFeedItem)
}