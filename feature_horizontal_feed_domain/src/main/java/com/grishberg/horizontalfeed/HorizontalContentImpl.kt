package com.grishberg.horizontalfeed

import com.grishberg.verticalfeeds.FeedContentOutputAction
import com.grishberg.verticalfeeds.FeedItem
import com.grishberg.verticalfeeds.NewsRenderer
import com.grishberg.verticalfeeds.VerticalFeedContent

class HorizontalContentImpl(
        private val inputBounds: InputBounds,
        private val verticalFeedContent: VerticalFeedContent,
        private val feedsToHorizontalItemsConverter: FeedConverter
) : HorizontalContent, InputBoundsAction, FeedContentOutputAction {
    private val actions = mutableListOf<OutputBoundsAction>()
    private val alerts = mutableListOf<HorizontalItem<*>>()
    private val feeds = mutableListOf<HorizontalItem<*>>()

    init {
        inputBounds.addInputAction(this)
        verticalFeedContent.registerOutputBoundsAction(this)
    }

    override fun registerOutputBoundsUpdateAction(action: OutputBoundsAction) {
        actions.add(action)
    }

    override fun unregisterOutputBoundsUpdateAction(action: OutputBoundsAction) {
        actions.remove(action)
    }

    override fun requestData() {
        inputBounds.requestItems()
        verticalFeedContent.requestData()
    }

    override fun onHorizontalItemUpdated() {
        alerts.clear()
        alerts.addAll(inputBounds.getItems())
        notifyHorizontalItemsUpdated()
    }

    override fun updateFeeds(newFeeds: List<FeedItem<*>>) {
        /* not used */
    }

    override fun onUpdateNews(news: List<FeedItem<NewsRenderer>>) {
        if (news.isEmpty()) {
            return
        }
        feeds.clear()
        feeds.add(feedsToHorizontalItemsConverter.convert(news)[0])
        notifyHorizontalItemsUpdated()
    }

    private fun notifyHorizontalItemsUpdated() {
        val content = mutableListOf<HorizontalItem<*>>()
        content.addAll(alerts)
        content.addAll(feeds)

        for (action in actions) {
            action.updateItems(content)
        }
    }
}