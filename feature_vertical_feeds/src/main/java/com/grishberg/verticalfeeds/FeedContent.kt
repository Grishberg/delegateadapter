package com.grishberg.verticalfeeds

/**
 * Vertical feed content use case.
 */
interface FeedContent {
    fun registerOutputBoundsAction(bounds: FeedContentOutputAction)
    fun unregisterOutputBounds(bounds: FeedContentOutputAction)
    fun requestData()

    object STUB : FeedContent {
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