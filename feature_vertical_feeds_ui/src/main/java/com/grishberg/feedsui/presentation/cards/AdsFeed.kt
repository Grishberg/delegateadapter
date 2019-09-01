package com.grishberg.feedsui.presentation.cards

import com.grishberg.detailedinfo.DetailedInfo
import com.grishberg.feedsui.presentation.cards.renderer.ads.AdsRenderer
import com.grishberg.verticalfeeds.AdsCard
import com.grishberg.verticalfeeds.CardType
import com.grishberg.verticalfeeds.FeedItem

internal class AdsFeed(
        private val id: Int,
        private val title: String,
        private val renderer: AdsRenderer) : AdsCard {
    override val type: CardType = CardType.ADS

    override fun render() {
        renderer.setTitle(title)
    }

    override fun isIdEquals(id: Int): Boolean = this.id == id
    override fun isIdEquals(other: FeedItem): Boolean = other.isIdEquals(id)
    override fun provideDetailedInfo(): DetailedInfo = DetailedInfo.STUB
}
