package com.grishberg.verticalfeeds

import com.grishberg.verticalfeeds.renderer.news.NewsRenderer

interface FeedContentOutputAction {
    fun updateFeeds(newFeeds: List<FeedItem<*>>)

    fun onUpdateNews(news: List<FeedItem<NewsRenderer>>) = Unit
}