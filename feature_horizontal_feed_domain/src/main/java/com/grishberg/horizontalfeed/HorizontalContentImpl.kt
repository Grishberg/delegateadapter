package com.grishberg.horizontalfeed

import com.grishberg.verticalfeeds.*

/**
 * Use case of horizontal cards.
 */
class HorizontalContentImpl(
        private val inputBounds: InputBounds,
        private val verticalFeedContent: FeedContent,
        private val feedsToHorizontalItemsConverter: FeedConverter
) : HorizontalContent, InputBoundsAction, FeedContentOutputAction {
    private val actions = mutableListOf<OutputBoundsAction>()
    private val alerts = mutableListOf<AnyHorizontalCard>()
    private val feeds = mutableListOf<AnyHorizontalCard>()

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

    override fun updateFeeds(newFeeds: List<AnyFeedItem>) {
        /* not used */
    }

    override fun onCardSelected(clickedCard: AnyHorizontalCard) {
        notifyCardSelected(clickedCard)
    }

    private fun notifyCardSelected(clickedCard: AnyHorizontalCard) {
        for (action in actions) {
            action.onItemSelected(clickedCard)
        }
    }

    override fun onUpdateNews(news: List<NewsCard>) {
        if (news.isEmpty()) {
            return
        }
        feeds.clear()
        feeds.add(feedsToHorizontalItemsConverter.convert(news)[0])
        notifyHorizontalItemsUpdated()
    }

    private fun notifyHorizontalItemsUpdated() {
        val content = mutableListOf<AnyHorizontalCard>()
        content.addAll(alerts)
        content.addAll(feeds)

        for (action in actions) {
            action.updateItems(content)
        }
    }
}