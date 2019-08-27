package com.grishberg.verticalfeeds

/**
 * Vertical feed content core abstraction.
 */
interface VerticalFeedContent {
    fun registerOutputBoundsAction(bounds: FeedContentOutputAction)
    fun unregisterOutputBounds(bounds: FeedContentOutputAction)
    fun requestData()

    object STUB : VerticalFeedContent {
        override fun registerOutputBoundsAction(bounds: FeedContentOutputAction) {
            /* stub */
        }

        override fun unregisterOutputBounds(bounds: FeedContentOutputAction) {
            /* stub */
        }

        override fun requestData() {
            /* stub */
        }
    }
}