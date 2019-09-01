package com.grishberg.feedsui.presentation.cards

import android.graphics.Color
import com.grishberg.detailedinfo.DetailedInfo
import com.grishberg.verticalfeeds.CardType
import com.grishberg.verticalfeeds.FeedItem
import com.grishberg.verticalfeeds.NewsCard
import com.grishberg.verticalfeeds.renderer.news.NewsRenderer

internal class NewsFeed(private val id: Int,
                        private val title: String,
                        private val description: String) : NewsCard {

    override fun isIdEquals(other: FeedItem<*>): Boolean {
        if (other !is NewsFeed) {
            return false
        }
        return id == other.id
    }

    override val type: CardType = CardType.NEWS

    override fun render(renderer: NewsRenderer) {
        renderer.showTitle(title)
        renderer.showDescription(description)
    }

    override fun provideDetailedInfo(): DetailedInfo = NewsDetailInfo(title, Color.CYAN)
}