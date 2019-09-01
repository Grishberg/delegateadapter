package com.grishberg.verticalfeeds

/**
 * Vertical feed content use case.
 */
interface FeedContent {
    fun registerOutputBoundsAction(bounds: FeedContentOutputAction)
    fun unregisterOutputBounds(bounds: FeedContentOutputAction)
    fun requestData()
}