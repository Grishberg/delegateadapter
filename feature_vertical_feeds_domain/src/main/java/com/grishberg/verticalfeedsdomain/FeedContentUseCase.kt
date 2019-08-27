package com.grishberg.verticalfeedsdomain

import com.grishberg.verticalfeeds.AnyFeedItem
import com.grishberg.verticalfeeds.FeedContent
import com.grishberg.verticalfeeds.FeedContentOutputAction
import com.grishberg.verticalfeeds.FeedsContentInputBounds
import javax.inject.Inject

/**
 * Feed items content use case.
 * listens different repository and updates content with items from repository.
 */
class FeedContentUseCase @Inject constructor(
        private val feedsRepository: FeedsContentInputBounds
) : FeedContent {
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

    private fun notifyFeedListChanged(feeds: List<AnyFeedItem>) {
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