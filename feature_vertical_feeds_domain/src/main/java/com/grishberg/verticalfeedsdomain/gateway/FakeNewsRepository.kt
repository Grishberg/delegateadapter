package com.grishberg.verticalfeedsdomain.gateway

import com.grishberg.verticalfeeds.CardsFactory
import com.grishberg.verticalfeeds.FeedsContentInputBounds
import com.grishberg.verticalfeeds.NewsCard

/**
 * Creates news feed items.
 */
internal class FakeNewsRepository(
        private val cardsFactory: CardsFactory
) : FeedsContentInputBounds {
    private val actions = mutableListOf<FeedsContentInputBounds.FeedReceivedAction>()
    private val feeds = mutableListOf<NewsCard>()
    private var lastId: Int = 0

    override fun addFeedReceivedAction(action: FeedsContentInputBounds.FeedReceivedAction) {
        actions.add(action)
        if (feeds.isNotEmpty()) {
            action.onFeedReceived()
        }
    }

    override fun removeFeedReceivedAction(action: FeedsContentInputBounds.FeedReceivedAction) {
        actions.remove(action)
    }

    override fun requestFeeds() {
        feeds.addAll(createFeeds())
        notifyFeedReceived()
    }

    private fun createFeeds(): List<NewsCard> {
        val feeds = mutableListOf<NewsCard>()
        for (i in 0 until 20) {
            feeds.add(cardsFactory.createNewsCard(lastId++, "title $lastId", "description $lastId"))
        }
        return feeds
    }

    private fun notifyFeedReceived() {
        for (action in actions) {
            action.onFeedReceived()
        }
    }

    override fun getFeeds(): List<NewsCard> {
        return feeds
    }
}