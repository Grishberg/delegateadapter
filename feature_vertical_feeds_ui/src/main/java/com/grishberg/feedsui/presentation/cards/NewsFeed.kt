package com.grishberg.feedsui.presentation.cards

import android.graphics.Color
import com.grishberg.detailedinfo.DetailedInfo
import com.grishberg.verticalfeeds.CardType
import com.grishberg.verticalfeeds.FeedItem
import com.grishberg.verticalfeeds.NewsCard
import com.grishberg.feedsui.presentation.cards.renderer.news.NewsRenderer

internal class NewsFeed(private val id: Int,
                        private val title: String,
                        private val description: String,
                        private val renderer: NewsRenderer) : NewsCard {

    override fun isIdEquals(id: Int): Boolean = this.id == id

    override fun isIdEquals(other: FeedItem): Boolean = other.isIdEquals(id)

    override val type: CardType = CardType.NEWS

    override fun render() {
        renderer.showTitle(title)
        renderer.showDescription(description)
    }

    override fun provideDetailedInfo(): DetailedInfo = NewsDetailInfo(title, Color.CYAN)
}