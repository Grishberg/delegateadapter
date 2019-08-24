package com.grishberg.verticalfeedsdomain.repository

import com.grishberg.verticalfeeds.FeedItem
import com.grishberg.verticalfeeds.FeedsContentInputBounds
import com.grishberg.verticalfeeds.NewsRenderer

internal class FakeRepository : FeedsContentInputBounds {
    private val actions = mutableListOf<FeedsContentInputBounds.FeedReceivedAction>()
    private val feeds = mutableListOf<NewsFeed>()
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

    private fun createFeeds(): MutableList<NewsFeed> {
        val feeds = mutableListOf<NewsFeed>()
        for (i in 0 until 20) {
            feeds.add(NewsFeed(lastId++, "title $lastId", "description $lastId"))
        }
        return feeds
    }

    private fun notifyFeedReceived() {
        for (action in actions) {
            action.onFeedReceived()
        }
    }

    override fun getFeeds(): List<FeedItem<NewsRenderer>> {
        return feeds
    }
}