package com.grishberg.verticalfeedsdomain

import com.grishberg.verticalfeeds.*
import javax.inject.Inject

/**
 * Abstraction of feed items content.
 * listens different repository and updates content with items from repository.
 */
class FeedContent @Inject constructor(
        private val feedsRepository: FeedsContentInputBounds
) : VerticalFeedContent {
    private val newsFeedReceivedAction = NewsFeedReceivedAction()
    private val outputBounds = mutableListOf<FeedContentOutputAction>()

    init {
        feedsRepository.addFeedReceivedAction(newsFeedReceivedAction)
    }

    override fun registerOutputBoundsAction(bounds: FeedContentOutputAction) {
        outputBounds.add(bounds)
    }

    override fun unregisterOutputBounds(bounds: FeedContentOutputAction) {
        outputBounds.remove(bounds)
    }

    private fun notifyFeedListChanged(feeds: List<FeedItem<*>>) {
        for (bounds in outputBounds) {
            bounds.updateFeeds(feeds)
        }
    }

    override fun requestData() {
        feedsRepository.requestFeeds()
    }

    private inner class NewsFeedReceivedAction : FeedsContentInputBounds.FeedReceivedAction {
        override fun onFeedReceived() {
            val feeds = feedsRepository.getFeeds()
            notifyFeedListChanged(feeds)

            for (bounds in outputBounds) {
                bounds.onUpdateNews(feeds)
            }
        }
    }
}