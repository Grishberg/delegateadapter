package com.grishberg.verticalfeeds

interface FeedContentOutputAction {
    fun updateFeeds(newFeeds: List<FeedItem<*>>)

    fun onUpdateNews(news: List<FeedItem<NewsRenderer>>) = Unit
}