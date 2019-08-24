package com.grishberg.verticalfeedsdomain.repository

import com.grishberg.verticalfeeds.FeedItem
import com.grishberg.verticalfeeds.NewsRenderer

private const val TYPE = "news"

internal class NewsFeed(private val id: Int,
                        private val title: String,
                        private val description: String) : FeedItem<NewsRenderer> {
    override fun getId(): Int = id

    override fun type() = TYPE

    override fun render(vh: NewsRenderer) {
        vh.showTitle(title)
        vh.showDescription(description)
    }
}