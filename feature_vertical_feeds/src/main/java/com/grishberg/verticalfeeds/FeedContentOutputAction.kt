package com.grishberg.verticalfeeds

interface FeedContentOutputAction {
    fun updateFeeds(newFeeds: List<AnyFeedItem>)

    fun onUpdateNews(news: List<NewsCard>) = Unit
}