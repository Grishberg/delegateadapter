package com.grishberg.verticalfeeds

interface FeedsContentInputBounds {
    interface FeedReceivedAction {
        fun onFeedReceived()
    }

    fun addFeedReceivedAction(action: FeedReceivedAction)

    fun removeFeedReceivedAction(action: FeedReceivedAction)

    fun requestFeeds()

    fun getFeeds() : List<NewsCard>
}