package com.grishberg.feedsui.presentation.cards

import com.grishberg.verticalfeeds.CardType
import com.grishberg.verticalfeeds.NewsCard
import com.grishberg.verticalfeeds.renderer.news.NewsRenderer

internal class NewsFeed(private val id: Int,
                        private val title: String,
                        private val description: String) : NewsCard {
    override fun getId(): Int = id

    override val type: CardType = CardType.NEWS

    override fun render(renderer: NewsRenderer) {
        renderer.showTitle(title)
        renderer.showDescription(description)
    }
}